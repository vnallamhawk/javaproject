/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rakesh
 * @param <T>
 */
public abstract class AbstractService<T> {

    @PersistenceContext(unitName = "vnallamhawkPU")
    private EntityManager em;

    private final Class<T> entityClass;
    
    /**
     *
     * @param entityClass
     */
    protected AbstractService(Class entityClass) {
        this.entityClass = entityClass;
    }

    /**
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return this.em;
    }

    /**
     *
     * @param entity
     */
    public void create(T entity) {
        em.persist(entity);
    }

    /**
     *
     * @param id
     * @return
     */
    public T find(Object id) {
        return em.find(entityClass, id);
    }

    /**
     *
     * @return
     */
    public abstract List<T> findAll();

    /**
     *
     * @param entity
     */
    public void update(T entity) {
        em.merge(entity);
    }

    /**
     *
     * @param entity
     */
    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    /**
     *
     * @param id
     */
    public void deleteById(Object id) {
        em.remove(em.getReference(entityClass, id));
    }
}
