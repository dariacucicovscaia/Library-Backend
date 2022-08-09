package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.Profile;

public interface ProfileDAO<Profile> extends IGenericDao<Profile> {
    Profile findProfileByEmail(String email);
}
