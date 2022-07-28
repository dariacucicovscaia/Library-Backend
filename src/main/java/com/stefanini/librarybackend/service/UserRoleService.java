package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.UserRole;

import java.util.List;

public interface UserRoleService {
    void createUserRole(UserRole user);
    void updateUserRole(UserRole user);
    List<UserRole> showAllUserRoles();
    UserRole findById(int id);
    UserRole findByEmail(String email);
    void deleteByEmail(String email);
    void deleteById(int id);
}
