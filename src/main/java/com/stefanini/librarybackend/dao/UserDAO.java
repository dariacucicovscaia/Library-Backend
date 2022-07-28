package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.User;

public interface UserDAO {
     User findUserByEmail(String userName);
}
