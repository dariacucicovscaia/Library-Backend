package dao;

import java.util.List;

public interface IGenericDao<T> {
    T findOne(final long id);

    List findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);



}
