package com.stefanini.librarybackend.dao;

import java.util.List;

public interface IGenericDao<T> {



    List<T> getAll() ;

    void update(T entity);

    void create(T entity);

    T get(int id) ;

    void remove(int id);



}