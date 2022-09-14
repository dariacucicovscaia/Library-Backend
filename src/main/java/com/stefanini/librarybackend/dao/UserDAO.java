package com.stefanini.librarybackend.dao;

import java.util.List;

public interface UserDAO<User> extends IGenericDao<User> {
    User findUserByEmail(String userName);

    List<User> getUsersByCriteria(String criteria);
}
