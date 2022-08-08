package com.stefanini.librarybackend.dao;

public interface UserDAO<User> extends IGenericDao<User> {
     User findUserByEmail(String userName);
}
