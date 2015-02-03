/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author italo.miranda
 */
public abstract class BasicRepository {

    private final EntityManager entityManager;

    public BasicRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected <T> List<T> getPureList(Class<T> classToCast, String query, Object... values) {

        Query qr = createQuery(query, values);
        return qr.getResultList();
    }

    protected <T> T getPurePojo(Class<T> classToCast, String query, Object... values) {

        Query qr = createQuery(query, values);
        return (T) qr.getSingleResult();
    }

    protected int executeCommand(String query, Object... values) {

        Query qr = createQuery(query, values);
        return qr.executeUpdate();
    }

    protected Query createQuery(String query, Object... values) {

        Query qr = getEntityManager().createQuery(query);

        for (int i = 0; i < values.length; i++) {
            qr.setParameter(i, values[i]);
        }

        return qr;
    }

    protected <T> T getEntity(Class<T> classToCast, Serializable pk) {
        return getEntityManager().find(classToCast, pk);
    }

    protected <T> T setEntity(Class<T> classToCast, Object entity) {

        Object updatedObject = getEntityManager().merge(entity);
        return (T) updatedObject;
    }

    protected void removeEntity(Object entity) {

        Object updatedObject = getEntityManager().merge(entity);
        getEntityManager().remove(updatedObject);
    }

    protected <T> T addEntity(Class<T> classToCast, Object entity) {
        
        getEntityManager().persist(entity);
        return (T) entity;
    }
}
