package edu.umg.dw.servicios.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class ServicioBase {
    @PersistenceContext
    protected EntityManager entityManager;

}
