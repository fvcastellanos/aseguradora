package edu.umg.dw.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public abstract class DaoBase {

    @PersistenceContext
    EntityManager entityManager;

//    @PersistenceUnit
//    private EntityManagerFactory entityManagerFactory;

    protected EntityManager getEntityManager() {
//        return entityManagerFactory.createEntityManager();

        return entityManager;
    }

}
