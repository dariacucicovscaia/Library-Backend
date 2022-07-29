package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.UserRole;

public interface UserRoleDAO<UserRole> extends IGenericDao<UserRole> {

   UserRole findUserRoleByEmail(String email) ;
}
