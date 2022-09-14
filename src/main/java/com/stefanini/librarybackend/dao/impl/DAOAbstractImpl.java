package com.stefanini.librarybackend.dao.impl;

import com.google.common.base.Preconditions;
import com.stefanini.librarybackend.dao.IGenericDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository
@Slf4j
public abstract class DAOAbstractImpl<T extends Serializable> implements IGenericDao<T> {
    private Class<T> clazz;
    @PersistenceContext
    EntityManager entityManager;

    public void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }

    // API
    @Override
    public List<T> getAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    @Transactional
    public T update(T entity) {
        entityManager.merge(entity);
        log.info("Entity {} was updated", entity.getClass().getName());
        return entity;
    }

    @Override
    @Transactional
    public T create(T entity) {
        entityManager.persist(entity);
        log.info("Entity {} was created", entity.getClass().getName());
        return entity;
    }

    @Override
    public T getById(int id) {
        return entityManager.find(clazz, id);
    }

    @Override
    @Transactional
    public int removeById(int id) {
        entityManager.remove(getById(id));
        log.info("Entity with id {} was removed", id);
        return id;
    }
}