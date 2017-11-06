package edu.umg.dw.servicios.ejb;

import edu.umg.dw.model.Asegurado;
import edu.umg.dw.servicios.ServicioAsegurado;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Objects.isNull;

@Stateless
public class ServicioAseguradoDefault implements ServicioAsegurado {

    private Logger logger = Logger.getLogger(ServicioAseguradoDefault.class.getName());

    @PersistenceContext
    EntityManager entityManager;

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

        if (isNull(busqueda) || !(busqueda.equals(asegurado))) {
            logger.info("no encontre al asegurado en cuestion");
            return null;
        }

        entityManager.merge(asegurado);
        entityManager.flush();;

        return asegurado;
    }

}
