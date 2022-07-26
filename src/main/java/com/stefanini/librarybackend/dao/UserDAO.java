package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.User;

public class UserDAO extends DAOAbstractImpl<User>{
    public UserDAO(){
        setClazz(User.class );
    }
}
