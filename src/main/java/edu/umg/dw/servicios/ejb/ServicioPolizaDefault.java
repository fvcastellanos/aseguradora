package edu.umg.dw.servicios.ejb;

import edu.umg.dw.dominio.Resultado;
import edu.umg.dw.model.Boleta;
import edu.umg.dw.model.Poliza;
import edu.umg.dw.servicios.ServicioPoliza;
import org.apache.commons.lang3.time.DateUtils;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static edu.umg.dw.dominio.Resultado.conError;
import static edu.umg.dw.dominio.Resultado.ok;
import static java.util.Objects.isNull;

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
            return conError(ex.getMessage());
        }
    }

    @Override
    public Poliza obtenerPoliza(int id) {

        return entityManager.createNamedQuery("Poliza.obtenerPorId", Poliza.class)
                .setParameter("id", id)
                .getResultList()
                .stream()
                .findFirst().orElse(null);
    }

    @Override
    @Transactional
    public Poliza crearPoliza(Poliza poliza) {

        try {
            Poliza p = obtenerPolizaPorNumero(poliza.getNoPoliza());

            if (!isNull(p)) {
                return null;
            }

            if (poliza.getNoPagos() == 0) {
                poliza.setNoPagos(1);
            }

            entityManager.persist(poliza);

            crearBoletas(poliza);

            entityManager.flush();

            return poliza;

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "no se pudo crear la poliza", ex);
        }

        return null;
    }

    @Override
    public Poliza actualizarPoliza(Poliza poliza) {

        Poliza p = obtenerPoliza(poliza.getId());

        if (isNull(p)) {
            return null;
        }



        entityManager.merge(poliza);
        entityManager.flush();

        return poliza;
    }

    @Override
    public List<Boleta> obtenerBoletasPoliza(int polizaId) {

        return entityManager.createNamedQuery("Boleta.boletasPoliza", Boleta.class)
                .setParameter("polizaId", polizaId)
                .getResultList();
    }

    // ---------------------------------------

    private Poliza obtenerPolizaPorNumero(String noPoliza) {
        return entityManager.createNamedQuery("Poliza.obtenerNumeroPoliza", Poliza.class)
                .setParameter("poliza", noPoliza)
                .getResultList()
                .stream()
                .findFirst().orElse(null);
    }

    private void crearBoletas(Poliza poliza) {

        Date fechaPago = DateUtils.addDays(poliza.getFechaEmision(), 30);

        for (int i = 0; i < poliza.getNoPagos(); i++) {
            Boleta boleta = new Boleta();

            boleta.setAnio(DateUtils.toCalendar(fechaPago).get(Calendar.YEAR));
            boleta.setMes(DateUtils.toCalendar(fechaPago).get(Calendar.MONTH) + 1);
            boleta.setCodigo(UUID.randomUUID().toString());
            boleta.setPoliza(poliza);
            boleta.setFechaPago(fechaPago);

            fechaPago = DateUtils.addDays(fechaPago, 30);
            entityManager.persist(boleta);
        }
    }
}
