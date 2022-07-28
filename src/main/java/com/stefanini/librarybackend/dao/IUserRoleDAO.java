package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.UserRole;

import javax.persistence.TypedQuery;

public interface IUserRoleDAO {

   UserRole findUserRoleByEmail(String email) ;
}
