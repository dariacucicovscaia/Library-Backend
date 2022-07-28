package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.Profile;

public interface IProfileDAO {
    Profile findProfileByEmail(String email);
}
