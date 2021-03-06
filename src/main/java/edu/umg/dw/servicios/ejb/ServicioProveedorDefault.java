package edu.umg.dw.servicios.ejb;


import edu.umg.dw.model.ConsultaCobertura;
import edu.umg.dw.model.ConsultaCoberturaMesYAnio;
import edu.umg.dw.model.ConsultaCoberturaNoPago;
import edu.umg.dw.model.Poliza;
import edu.umg.dw.model.Proveedor;
import edu.umg.dw.servicios.ServicioProveedor;
import edu.umg.dw.servicios.dominio.ContextoProveedor;
import edu.umg.dw.servicios.dominio.Resultado;
import edu.umg.dw.sw.vistas.PeticionConsultaPaciente;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static edu.umg.dw.servicios.dominio.Resultado.conError;
import static edu.umg.dw.servicios.dominio.Resultado.ok;
import static java.util.logging.Level.SEVERE;

@Stateless
public class ServicioProveedorDefault extends ServicioBase implements ServicioProveedor {

    private static final String SIN_COBERTURA = "Sin Cobertura";

    private static final Logger logger = Logger.getLogger(ServicioProveedorDefault.class.getName());

    @Override
    public Resultado<String, List<Proveedor>> obtenerProveedores() {

        try {
            logger.info("Obteniendo el listado de proveedores");

            return ok(obtenerListadoProveedores());

        } catch (Exception ex) {
            logger.log(SEVERE, "No se puede obtener el listado de proveedores ", ex);

            return conError("No se puede obtener el listado de proveedores");
        }
    }

    @Override
    public Resultado<String, Proveedor> obtenerProveedor(String nit) {
        try {
            logger.info("Obteniendo el listado de proveedores");

            Optional<Proveedor> contenedor = buscarProveedor(nit);

            if (!contenedor.isPresent()) {
                return conError("No se encuentra el proveedor");
            }

            return ok(contenedor.get());

        } catch (Exception ex) {
            logger.log(SEVERE, "No se puede obtener el proveedor ", ex);

            return conError("No se puede obtener el proveedor");
        }
    }

    @Override
    @Transactional
    public Resultado<String, Proveedor> agregarProveedor(Proveedor proveedor) {

        try {
            ContextoProveedor contextoProveedor = new ContextoProveedor(proveedor.getNit());
            contextoProveedor.setProveedor(proveedor);

            return verificarNitExistente(contextoProveedor)
                    .despues(this::guardarNuevoProveedor)
                    .despues(this::cargarProveedor)
                    .map(ContextoProveedor::getProveedor);
        } catch (Exception ex) {
            logger.log(SEVERE, "No se puede agregar el proveedor ", ex);

            return conError("No se puede agregar el proveedor");
        }
    }

    @Override
    @Transactional
    public Resultado<String, Proveedor> modificarProveedor(Proveedor proveedor) {

        try {
            ContextoProveedor contextoProveedor = new ContextoProveedor(proveedor.getNit());
            contextoProveedor.setProveedor(proveedor);

            return actualizarProveedor(contextoProveedor)
                    .map(ContextoProveedor::getProveedor);
        } catch (Exception ex) {
            logger.log(SEVERE, "No se puede agregar el proveedor ", ex);

            return conError("No se puede agregar el proveedor");
        }
    }

    @Override
    public Resultado<String, ConsultaCobertura> obtenerConsultaCobertura(final PeticionConsultaPaciente peticionConsultaPaciente) {
        try {
            ContextoProveedor contextoProveedor = new ContextoProveedor(peticionConsultaPaciente.getNitProveedor());
            contextoProveedor.setNoPoliza(peticionConsultaPaciente.getNoPoliza());
            contextoProveedor.setFechaNacimiento(peticionConsultaPaciente.getFechaNacimientoPaciente());

            Resultado<String, String> resultado = cargarProveedor(contextoProveedor)
                    .despues(this::obtenerPoliza)
                    .despues(this::verificarFechaNacimiento)
                    .despues(this::generarAutorizacion)
                    .map(ContextoProveedor::getAutorizacion);

            if (resultado.tieneFalla()) {
                return conError(resultado.getError());
            }

            return crearConsultaCobertura(resultado.getObjeto(), contextoProveedor.getNit(), contextoProveedor.getPoliza());

        } catch (Exception exception) {
            logger.log(SEVERE, "No se puede realizar la consulta desde el Servicio Web para obtener la poliza del asegurado.", exception);
            return conError("No se puede realizar la consulta desde el Servicio Web para obtener la poliza del asegurado.");
        }
    }

    // -------------------------------------------------
    @Override
    public Resultado<String, List<ConsultaCobertura>> obtenerConsultasCobertura(final String nitProveedor) {
        try {
            final List<ConsultaCobertura> consultaCoberturas = entityManager.createNamedQuery("ConsultaCobertura.findAll", ConsultaCobertura.class).getResultList()
                         .stream()
                         .filter(consultaCobertura -> consultaCobertura.getNitProveedor().equalsIgnoreCase(nitProveedor))
                         .collect(Collectors.toList());
            return ok(consultaCoberturas);
        } catch (final Exception exception) {
            logger.log(SEVERE, "No se puede obtener el listado de consultas de cobertura.", exception);
            return conError("No se puede obtener el listado de consultas de cobertura.");
        }
    }

    @Override
    public Resultado<String, List<ConsultaCoberturaNoPago>> obtenerConsultasCoberturaNoPago() {
        try {
            final List<ConsultaCoberturaNoPago> consultaCoberturaNoPagos = entityManager.createNamedQuery("ConsultaCoberturaNoPago.findConsultaCoberturaNoPago", ConsultaCoberturaNoPago.class).getResultList();

            return ok(consultaCoberturaNoPagos);
        } catch (final Exception exception) {
            logger.log(SEVERE, "No se puede obtener el listado de consultas de cobertura.", exception);
            return conError("No se puede obtener el listado de consultas de cobertura.");
        }
    }

    @Override
    public Resultado<String, List<ConsultaCoberturaMesYAnio>> obtenerConsultaCoberturaMesYAnio(final String noPoliza) {
        try {
            final List<ConsultaCoberturaMesYAnio> consultaCoberturaMesYAnios = entityManager.createNamedQuery("ConsultaCoberturaMesYAnio.findConsultaCoberturaMesYAnioPorNoPoliza", ConsultaCoberturaMesYAnio.class)
                                                                                            .setParameter(1, noPoliza).getResultList();
            return ok(consultaCoberturaMesYAnios);
        } catch (final Exception exception) {
            logger.log(SEVERE, "No se puede obtener el listado de consultas de cobertura.", exception);
            return conError("No se puede obtener el listado de consultas de cobertura.");
        }
    }

    @Override
    public Resultado<String, List<ConsultaCoberturaMesYAnio>> obtenerConsultaTotalCoberturaMesYAnio() {
        try {
            final List<ConsultaCoberturaMesYAnio> consultaCoberturaMesYAnios = entityManager.createNamedQuery("ConsultaCoberturaMesYAnio.totalConsultaCoberturaMesYAnio", ConsultaCoberturaMesYAnio.class).getResultList();
            return ok(consultaCoberturaMesYAnios);
        } catch (final Exception exception) {
            logger.log(SEVERE, "No se puede obtener el listado de consultas de cobertura.", exception);
            return conError("No se puede obtener el listado de consultas de cobertura.");
        }
    }

    private Resultado<String, ConsultaCobertura> crearConsultaCobertura(final String mensaje, final String nitProveedor, final Poliza poliza) {
        final ConsultaCobertura consultaCobertura = new ConsultaCobertura(mensaje, new Date(), nitProveedor, poliza);
        entityManager.persist(consultaCobertura);
        entityManager.flush();

        return ok(consultaCobertura);
    }

    // -----------------------------

    private List<Proveedor> obtenerListadoProveedores() {
        return entityManager.createNamedQuery("Proveedor.findAll", Proveedor.class)
                .getResultList();
    }

    private Optional<Proveedor> buscarProveedor(String nit) {
        return obtenerListadoProveedores().stream()
                .filter(proveedor -> nit.equals(proveedor.getNit()))
                .findFirst();
    }

    private Optional<Poliza> buscarPoliza(String noPoliza) {
        return entityManager.createNamedQuery("Poliza.obtenerNumeroPoliza", Poliza.class)
                .setParameter("poliza", noPoliza)
                .getResultList()
                .stream()
                .findFirst();
    }

    // -----------------------------

    private Resultado<String, ContextoProveedor> verificarNitExistente(ContextoProveedor contextoProveedor) {

        String nit = contextoProveedor.getNit();

        Optional<Proveedor> contenedor = buscarProveedor(nit);

        if (contenedor.isPresent()) {
            return conError("Proveedor existente");
        }

        return ok(contextoProveedor);
    }

    private Resultado<String, ContextoProveedor> guardarNuevoProveedor(ContextoProveedor contextoProveedor) {
        Proveedor proveedor = contextoProveedor.getProveedor();

        entityManager.persist(proveedor);
        entityManager.flush();

        return ok(contextoProveedor);
    }

    private Resultado<String, ContextoProveedor> actualizarProveedor(ContextoProveedor contextoProveedor) {
        Proveedor proveedor = contextoProveedor.getProveedor();

        entityManager.merge(proveedor);
        entityManager.flush();

        proveedor = entityManager.find(Proveedor.class, proveedor.getId());
        contextoProveedor.setProveedor(proveedor);

        return ok(contextoProveedor);
    }

    private Resultado<String, ContextoProveedor> cargarProveedor(ContextoProveedor contextoProveedor) {

        String nit = contextoProveedor.getNit();

        Optional<Proveedor> contenedor = buscarProveedor(nit);

        if (!contenedor.isPresent()) {
            return conError("Proveedor no existente");
        }

        contextoProveedor.setProveedor(contenedor.get());
        return ok(contextoProveedor);
    }

    private Resultado<String, ContextoProveedor> obtenerPoliza(ContextoProveedor contextoProveedor) {
        String noPoliza = contextoProveedor.getNoPoliza();

        Optional<Poliza> contenedor = buscarPoliza(noPoliza);

        if (!contenedor.isPresent()) {
            return conError("Poliza no existe");
        }

        contextoProveedor.setPoliza(contenedor.get());

        return ok(contextoProveedor);
    }

    private Resultado<String, ContextoProveedor> verificarFechaNacimiento(ContextoProveedor contextoProveedor) {
        Poliza poliza = contextoProveedor.getPoliza();

        if (!poliza.getFechaNacimiento().equals(contextoProveedor.getFechaNacimiento())) {
            return conError("Fechas de nacimiento no coinciden");
        }

        return ok(contextoProveedor);
    }

    private Resultado<String, ContextoProveedor> generarAutorizacion(ContextoProveedor contextoProveedor) {
        Poliza poliza = contextoProveedor.getPoliza();

        String autorizacion = "Sin cobertura";
        if (poliza.getActiva() == 1) {
            autorizacion = UUID.randomUUID().toString();
        }

        contextoProveedor.setAutorizacion(autorizacion);
        return ok(contextoProveedor);
    }
}
