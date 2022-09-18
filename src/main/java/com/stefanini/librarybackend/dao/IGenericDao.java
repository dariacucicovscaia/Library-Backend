package com.stefanini.librarybackend.dao;

import java.util.List;

/**
 * Generic dao class for crud entity operations.
 *
 * @param <T>
 */
public interface IGenericDao<T> {

    /**
     * Get all entities.
     *
     * @return list of all entities
     */
    List<T> getAll();

    /**
     * Update entity.
     *
     * @param entity
     * @return updated entity
     */
    T update(T entity);

    /**
     * Create entity.
     *
     * @param entity
     * @return created entity
     */
    T create(T entity);

    /**
     * Get entity by id.
     *
     * @param id of entity to be found
     * @return entity
     */
    T getById(int id);

    /**
     * Remove by id.
     *
     * @param id of entity to be found
     * @return id of removed entity
     */
    int removeById(int id);


}