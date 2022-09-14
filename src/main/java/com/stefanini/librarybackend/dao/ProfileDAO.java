package com.stefanini.librarybackend.dao;

public interface ProfileDAO<Profile> extends IGenericDao<Profile> {
    Profile findProfileByEmail(String email);
}
