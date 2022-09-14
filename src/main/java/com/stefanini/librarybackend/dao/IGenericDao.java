package com.stefanini.librarybackend.dao;

import java.util.List;

public interface IGenericDao<T> {


    List<T> getAll();

    T update(T entity);

    T create(T entity);

    T getById(int id);

    int removeById(int id);


}