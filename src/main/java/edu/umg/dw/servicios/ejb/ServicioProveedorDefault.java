package edu.umg.dw.servicios.ejb;


import edu.umg.dw.model.Proveedor;
import edu.umg.dw.servicios.ServicioProveedor;
import edu.umg.dw.servicios.dominio.ContextoProveedor;
import edu.umg.dw.servicios.dominio.Resultado;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static edu.umg.dw.servicios.dominio.Resultado.conError;
import static edu.umg.dw.servicios.dominio.Resultado.ok;

@Stateless
public class ServicioProveedorDefault extends ServicioBase implements ServicioProveedor {

    private Logger logger = Logger.getLogger(ServicioProveedorDefault.class.getName());

    @Override
    public Resultado<String, List<Proveedor>> obtenerProveedores() {

        try {
            logger.info("Obteniendo el listado de proveedores");

            return ok(obtenerListadoProveedores());

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se puede obtener el listado de proveedores ", ex);

            return conError("No se puede obtener el listado de proveedores");
        }
    }

    @Override
    public Resultado<String, Proveedor> obtenerProveedor(String nit) {
        try {
            logger.info("Obteniendo el listado de proveedores");

            Optional<Proveedor> contenedor = buscarProveedor(nit);

            if (contenedor.isPresent()) {
                return conError("No se encuentra el proveedor");
            }

            return ok(contenedor.get());

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se puede obtener el proveedor ", ex);

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
            logger.log(Level.SEVERE, "No se puede agregar el proveedor ", ex);

            return conError("No se puede agregar el proveedor");
        }
    }

    @Override
    @Transactional
    public Resultado<String, Proveedor> modificarProveedor(Proveedor proveedor) {

        try {
            ContextoProveedor contextoProveedor = new ContextoProveedor(proveedor.getNit());

            return cargarProveedor(contextoProveedor)
                    .despues(this::actualizarProveedor)
                    .map(ContextoProveedor::getProveedor);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se puede agregar el proveedor ", ex);

            return conError("No se puede agregar el proveedor");
        }
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

        proveedor = entityManager.merge(proveedor);
        entityManager.flush();

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
}
