package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Profile;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(int id, User user);
    List<User> showAllUsers();
    public User findById(int id);
    User findByEmail(String email);
    int deleteByEmail(String email);
    int deleteById(int id);
    public User assignRole(int id, Role role);
    User registerUser(User user, Profile profile);
}
