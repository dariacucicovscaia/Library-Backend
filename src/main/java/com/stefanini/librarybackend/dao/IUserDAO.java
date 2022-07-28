package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.User;

public interface IUserDAO {
     User findUserByEmail(String userName);
}
