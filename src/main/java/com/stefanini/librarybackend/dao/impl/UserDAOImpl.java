package com.stefanini.librarybackend.dao.impl;

import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.domain.User;

import javax.persistence.TypedQuery;

public class UserDAOImpl extends DAOAbstractImpl<User> implements UserDAO {
    public UserDAOImpl() {
        setClazz(User.class);
    }

    @Override
    public User findUserByEmail(String email) {
        TypedQuery query = entityManager.createQuery("select a from User a where a.email = ?1", User.class);
        query.setParameter(1, email);
        return (User) query.getSingleResult();
    }
}
