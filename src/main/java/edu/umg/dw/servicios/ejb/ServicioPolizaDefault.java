package edu.umg.dw.servicios.ejb;

import edu.umg.dw.model.Poliza;
import edu.umg.dw.servicios.ServicioPoliza;

import javax.ejb.Stateless;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static java.util.Objects.isNull;

@Stateless
public class ServicioPolizaDefault extends ServicioBase implements ServicioPoliza {

    private Logger logger = Logger.getLogger(ServicioPolizaDefault.class.getName());

/*
    @Override
    public List<Asegurado> obtenerAsegurados() {

        return entityManager.createNamedQuery("Asegurado.findAll", Asegurado.class)
                .getResultList();
    }

    @Override
    public Asegurado obtenerAsegurado(int id) {
        return entityManager.createNamedQuery("Asegurado.findById", Asegurado.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Asegurado crearAsegurado(Asegurado asegurado) {

        entityManager.persist(asegurado);
        entityManager.flush();

        return asegurado;
    }

    @Override
    public Asegurado actualizarAsegurado(Asegurado asegurado) {

        if (isNull(asegurado)) {
            logger.info("asegurado es nulo");
            return null;
        }

        Asegurado busqueda = obtenerAsegurado(asegurado.getId());

        if (isNull(busqueda)) {
            logger.info("no encontre al asegurado en cuestion");
            return null;
        }

        entityManager.merge(asegurado);
        entityManager.flush();;

        return asegurado;
    }

    @Override
    public List<Poliza> obtenerPolizasAsegurado(int idAsegurado) {

        return entityManager.createNamedQuery("Asegurado.obtenerPolizas", Poliza.class)
                .setParameter("id", idAsegurado)
                .getResultList();
    }

    @Override
    public Poliza crearPolizaAsegurado(int idAsegurado, Poliza poliza) {

        Asegurado asegurado = obtenerAsegurado(idAsegurado);

        if (isNull(asegurado)) {
            return null;
        }

        poliza.setAsegurado(asegurado);
        entityManager.persist(poliza);
        entityManager.flush();

        return poliza;
    }
*/

    @Override
    public List<Poliza> obtenerPolizas() {
        return entityManager.createNamedQuery("Poliza.findAll", Poliza.class)
                .getResultList();
    }

    @Override
    public Poliza obtenerPoliza(int id) {
        return obtenerPolizas().stream()
                .filter(poliza -> poliza.getId() == id)
                .findFirst().orElseGet(null);
    }

    @Override
    public Poliza crearPoliza(Poliza poliza) {

        Poliza p = obtenerPoliza(poliza.getNoPoliza());

        if (!isNull(p)) {
            return null;
        }

        // Hacer validaciones y agregar pagos

        entityManager.persist(poliza);
        entityManager.flush();

        return poliza;
    }

    @Override
    public Poliza actualizarPoliza(Poliza poliza) {
        return null;
    }

    private Poliza obtenerPoliza(String noPoliza) {
        return entityManager.createNamedQuery("Poliza.obtenerNumeroPoliza", Poliza.class)
                .setParameter("poliza", noPoliza)
                .getSingleResult();
    }

}
