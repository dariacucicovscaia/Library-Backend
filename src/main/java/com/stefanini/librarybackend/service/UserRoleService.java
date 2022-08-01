package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole createUserRole(UserRole user);
    UserRole updateUserRole(UserRole user);
    List<UserRole> showAllUserRoles();
    UserRole findById(int id);
    UserRole findByEmail(String email);
    int deleteByEmail(String email);
    int deleteById(int id);
}
