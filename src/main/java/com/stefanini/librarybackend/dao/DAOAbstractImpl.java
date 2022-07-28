package com.stefanini.librarybackend.dao;
import com.google.common.base.Preconditions;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public abstract class DAOAbstractImpl<T extends Serializable>  implements IGenericDao<T> {
    private Class<T> clazz;

    @PersistenceContext
    EntityManager entityManager;


    private EntityTransaction transaction = null;
    private Logger logger = Logger.getLogger(DAOAbstractImpl.class);
    public void setClazz(final Class<T> clazzToSet) {
        // System.out.println( Preconditions.checkNotNull(clazzToSet));
        clazz = Preconditions.checkNotNull(clazzToSet);
    }
    // API
    @Override
    public List<T> getAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public void update(T entity) {
        try {

            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage());
            //  } finally {
            //      shutdown();
        }
    }

    @Override
    public void create(T entity) {
        try {
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage());

        } finally {
            //  shutdown();
        }
    }

    @Override
    public T get(int id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public void remove(int id) {
        try {
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.remove(get(id));
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage());
        } finally {
        }
    }
}