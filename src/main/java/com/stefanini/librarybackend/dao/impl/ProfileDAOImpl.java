package com.stefanini.librarybackend.dao.impl;

import com.stefanini.librarybackend.dao.ProfileDAO;
import com.stefanini.librarybackend.domain.Profile;
import com.stefanini.librarybackend.domain.UserRole;

import javax.persistence.TypedQuery;

public class ProfileDAOImpl extends DAOAbstractImpl<Profile> implements ProfileDAO {
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
