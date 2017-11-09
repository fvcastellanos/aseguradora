package edu.umg.dw.servicios.ejb;

import com.google.common.collect.Lists;
import edu.umg.dw.model.Boleta;
import edu.umg.dw.model.Poliza;
import edu.umg.dw.servicios.ServicioPoliza;
import edu.umg.dw.servicios.dominio.ContextoPoliza;
import edu.umg.dw.servicios.dominio.Resultado;
import org.apache.commons.lang3.time.DateUtils;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static edu.umg.dw.servicios.dominio.Resultado.conError;
import static edu.umg.dw.servicios.dominio.Resultado.ok;

@Stateless
public class ServicioPolizaDefault extends ServicioBase implements ServicioPoliza {

    private Logger logger = Logger.getLogger(ServicioPolizaDefault.class.getName());

    @Override
    public Resultado<String, List<Poliza>> obtenerPolizas() {
        try {

            List<Poliza> listado = entityManager.createNamedQuery("Poliza.findAll", Poliza.class)
                    .getResultList();

            return ok(listado);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "no se pudo obtener las polizas: ", ex);
            return conError("No se pudo obtener el listado de polizas");
        }
    }

    @Override
    public Resultado<String, Poliza> obtenerPoliza(String noPoliza) {
        ContextoPoliza contextoPoliza = new ContextoPoliza(noPoliza);
        try {
            return obtenerPoliza(contextoPoliza)
                    .map(ContextoPoliza::getPoliza);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "algo paso...", ex);
            return conError("No se pudo obtener la poliza");
        }
    }

    @Override
    @Transactional
    public Resultado<String, Poliza> crearPoliza(Poliza poliza) {

        ContextoPoliza contextoPoliza = new ContextoPoliza(poliza.getNoPoliza());

        try {

            contextoPoliza.setPoliza(poliza);

            return verificarExistenciaPoliza(contextoPoliza)
                .despues(this::generarBoletas)
                .despues(this::guardarNuevaPoliza)
                .despues(this::obtenerPoliza)
                .map(ContextoPoliza::getPoliza);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "no se pudo crear la poliza", ex);
            return conError("No se pudo crear la poliza");
        }
    }

    @Override
    @Transactional
    public Resultado<String, Poliza> actualizarPoliza(Poliza poliza) {

        ContextoPoliza contextoPoliza = new ContextoPoliza(poliza.getNoPoliza());
        contextoPoliza.setPolizaModificada(poliza);

        try {

            return obtenerPoliza(contextoPoliza)
                    .despues(this::eliminarBoletas)
                    .despues(this::generarBoletas)
                    .despues(this::actualizarPoliza)
                    .map(ContextoPoliza::getPoliza);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se puede actualizar la poliza: ", ex);

            return conError("No se puede actualizar la poliza");
        }
    }

    @Override
    public Resultado<String, List<Boleta>> obtenerBoletasPoliza(String noPoliza) {

        try {
            List<Boleta> boletas = obtenerBoletasPorPoliza(noPoliza);

            return ok(boletas);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se puede obtener el listado de boletas de la poliza: ", ex);

            return conError("No se puede obtener el listado de boletas de la poliza");
        }
    }

    @Override
    @Transactional
    public Resultado<String, Boleta> pagarBoleta(String noPoliza, int mes, int anio) {

        ContextoPoliza contextoPoliza = new ContextoPoliza(noPoliza);
        contextoPoliza.setMes(mes);
        contextoPoliza.setAnio(anio);

        try {
            return obtenerBoletaPago(contextoPoliza)
                .despues(this::actualizarBoleta)
                .map(ContextoPoliza::getBoleta);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se puede pagar la boleta: ", ex);

            return conError("No se puede pagar la boleta");
        }
    }

    // ---------------------------------------

    private Optional<Poliza> obtenerPolizaPorNumero(String noPoliza) {
        return entityManager.createNamedQuery("Poliza.obtenerNumeroPoliza", Poliza.class)
                .setParameter("poliza", noPoliza)
                .getResultList()
                .stream()
                .findFirst();
    }

    private List<Boleta> obtenerBoletasPorPoliza(String noPoliza) {
        return entityManager.createNamedQuery("Boleta.boletasPoliza", Boleta.class)
                .setParameter("noPoliza", noPoliza)
                .getResultList();
    }

    // ---------------------------------------


    private Resultado<String, ContextoPoliza> obtenerPoliza(ContextoPoliza contextoPoliza) {

        String noPoliza = contextoPoliza.getNoPoliza();

        Optional<Poliza> contenedor = obtenerPolizaPorNumero(noPoliza);

        if (!contenedor.isPresent()) {
            return conError("Poliza no encontrada");
        }

        contextoPoliza.setPoliza(contenedor.get());
        return ok(contextoPoliza);
    }

    private Resultado<String, ContextoPoliza> verificarExistenciaPoliza(ContextoPoliza contextoPoliza) {

        String noPoliza = contextoPoliza.getNoPoliza();

        Optional<Poliza> contenedor = obtenerPolizaPorNumero(noPoliza);

        if (contenedor.isPresent()) {
            return conError("La poliza ya existe");
        }

        return ok(contextoPoliza);
    }

    private Resultado<String, ContextoPoliza> generarBoletas(ContextoPoliza contextoPoliza) {

        Poliza poliza = contextoPoliza.getPoliza();

        if (poliza.getNoPagos() <= 0) {
            poliza.setNoPagos(1);
        }

        List<Boleta> boletas = Lists.newArrayList();

        Date fechaPago = DateUtils.addDays(poliza.getFechaEmision(), 30);

        for (int i = 0; i < poliza.getNoPagos(); i++) {
            Boleta boleta = new Boleta();

            boleta.setAnio(DateUtils.toCalendar(fechaPago).get(Calendar.YEAR));
            boleta.setMes(DateUtils.toCalendar(fechaPago).get(Calendar.MONTH) + 1);
            boleta.setCodigo(UUID.randomUUID().toString());
            boleta.setPoliza(poliza);
            boleta.setFechaPago(fechaPago);

            boletas.add(boleta);

            fechaPago = DateUtils.addDays(fechaPago, 30);
        }

        contextoPoliza.setBoletas(boletas);
        return ok(contextoPoliza);
    }

    private Resultado<String, ContextoPoliza> guardarNuevaPoliza(ContextoPoliza contextoPoliza) {
        Poliza poliza = contextoPoliza.getPoliza();

        entityManager.persist(poliza);
        entityManager.flush();

        return ok(contextoPoliza);
    }

    private Resultado<String, ContextoPoliza> actualizarPoliza(ContextoPoliza contextoPoliza) {

        Poliza poliza = contextoPoliza.getPolizaModificada();
        poliza = entityManager.merge(poliza);

        contextoPoliza.getBoletas().stream()
                .forEach(boleta -> {
                    entityManager.merge(boleta);
                });

        entityManager.flush();

        contextoPoliza.setPoliza(poliza);

        return ok(contextoPoliza);
    }

    private Resultado<String, ContextoPoliza> eliminarBoletas(ContextoPoliza contextoPoliza) {
        Poliza poliza = contextoPoliza.getPoliza();
        Poliza polizaModificada = contextoPoliza.getPolizaModificada();

        List<Boleta> boletas = obtenerBoletasPorPoliza(poliza.getNoPoliza());

        boolean existenBoletasPagadas = boletas.stream()
                .anyMatch(boleta -> boleta.getPagada().equals("S"));

        if ((poliza.getNoPagos() != polizaModificada.getNoPagos()) && existenBoletasPagadas) {
            return conError("Existen boletas pagadas para la poliza, no se puede modificar");
        }

        // verificar fechas de emision y vencimiento

        boletas.forEach(boleta -> {
            entityManager.remove(boleta);
        });

        entityManager.flush();

        return ok(contextoPoliza);
    }

    private Resultado<String, ContextoPoliza> obtenerBoletaPago(ContextoPoliza contextoPoliza) {

        String noPoliza = contextoPoliza.getNoPoliza();
        int mes = contextoPoliza.getMes();
        int anio = contextoPoliza.getAnio();

        Optional<Boleta> contenedor = obtenerBoletasPorPoliza(noPoliza).stream()
                .filter(boleta -> {
                    if ((boleta.getMes() == mes) && (boleta.getAnio() == anio)) {
                        return true;
                    }

                    return false;
                }).findFirst();

        if (!contenedor.isPresent()) {
            conError("Boleta no encontrada");
        }

        contextoPoliza.setBoleta(contenedor.get());

        return ok(contextoPoliza);
    }

    private Resultado<String, ContextoPoliza> actualizarBoleta(ContextoPoliza contextoPoliza) {

        Boleta boleta = contextoPoliza.getBoleta();

        boleta.setPagada("S");
        boleta.setFechaPago(new Date());

        boleta = entityManager.merge(boleta);
        entityManager.flush();
        contextoPoliza.setBoleta(boleta);

        return ok(contextoPoliza);
    }
}
