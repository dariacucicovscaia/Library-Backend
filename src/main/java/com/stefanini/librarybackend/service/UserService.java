package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(int id, User user);
    List<User> showAllUsers();
    public User findById(int id);
    User findByEmail(String email);
    int deleteByEmail(String email);
    int deleteById(int id);
}
