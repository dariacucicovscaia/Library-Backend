package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.dao.DAOAbstractImpl;
import com.stefanini.librarybackend.dao.IProfileDAO;
import com.stefanini.librarybackend.domain.Profile;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.UserRole;

import javax.persistence.TypedQuery;

public class ProfileDAOImpl extends DAOAbstractImpl<Profile> implements IProfileDAO {
    public ProfileDAOImpl() {
        setClazz(Profile.class);
    }

    @Override
    public Profile findProfileByEmail(String email) {
        TypedQuery query = entityManager.createQuery("select a from UserRole a where a.email = ?1", UserRole.class);
        query.setParameter(1, email);
        return (Profile) query.getSingleResult();
    }

}
