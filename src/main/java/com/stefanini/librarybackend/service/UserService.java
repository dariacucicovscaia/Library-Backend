package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void updateUser(User user);
    List<User> showAllUsers();
    public User findById(int id);
    User findByEmail(String email);
    void deleteByEmail(String email);
    void deleteById(int id);
}
