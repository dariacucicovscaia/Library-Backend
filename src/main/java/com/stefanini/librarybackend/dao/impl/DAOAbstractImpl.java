package com.stefanini.librarybackend.dao.impl;

import com.google.common.base.Preconditions;
import com.stefanini.librarybackend.dao.IGenericDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public abstract class DAOAbstractImpl<T extends Serializable> implements IGenericDao<T> {
    private Class<T> clazz;
    @PersistenceContext
    EntityManager entityManager;

    private Logger logger = Logger.getLogger(DAOAbstractImpl.class);

    public void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }

    // API
    @Override
    public List<T> getAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T get(int id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public void remove(int id) {
        entityManager.remove(get(id));
    }
}