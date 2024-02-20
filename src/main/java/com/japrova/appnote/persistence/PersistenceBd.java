package com.japrova.appnote.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class PersistenceBd {

    private final String NOMBRE_PERSISTENCE = "NotePU";
    private EntityManager entityManager = null;

    public  EntityManager getPersistence() {

        if(entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory(NOMBRE_PERSISTENCE)
                    .createEntityManager();
        }
        return entityManager;
    }
}