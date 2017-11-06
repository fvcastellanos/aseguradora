package edu.umg.dw.servicios.ejb;

import edu.umg.dw.model.Asegurado;
import edu.umg.dw.servicios.ServicioAsegurado;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ServicioAseguradoDefault implements ServicioAsegurado {

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
                .getSingleResult();
    }

    @Override
    public Asegurado crearAsegurado(Asegurado asegurado) {

        entityManager.persist(asegurado);
        entityManager.flush();

        return asegurado;
    }

    @Override
    public boolean desactivarAsegurado(int id) {

        Asegurado asegurado = obtenerAsegurado(id);

        if (asegurado != null) {
            asegurado.setActivo((short) 0);

            entityManager.merge(asegurado);
            entityManager.flush();

            return true;
        }

        return false;
    }
}
