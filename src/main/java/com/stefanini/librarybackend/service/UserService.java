package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    List<User> showAllUsers();
    public User findById(int id);
    User findByEmail(String email);
    User deleteByEmail(String email);
    User deleteById(int id);
}
