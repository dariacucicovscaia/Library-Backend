package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.dao.DAOAbstractImpl;
import com.stefanini.librarybackend.dao.IUserRoleDAO;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.UserRole;

import javax.persistence.TypedQuery;

public class UserRoleDAOImpl  extends DAOAbstractImpl<UserRole> implements IUserRoleDAO {

    public UserRoleDAOImpl() {
        setClazz(UserRole.class);
    }

    @Override
    public UserRole findUserRoleByEmail(String email) {
        TypedQuery query = entityManager.createQuery("select a from UserRole a where a.email = ?1", UserRole.class);
        query.setParameter(1, email);
        return (UserRole) query.getSingleResult();
    }
}
