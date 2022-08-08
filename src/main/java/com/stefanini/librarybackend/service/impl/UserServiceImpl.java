package com.stefanini.librarybackend.service.impl;


import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.dao.impl.UserDAOImpl;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;
import com.stefanini.librarybackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO<User> userDao;

    private final PasswordEncoder passwordEncoder;


    @Override
    public User createUser(User user) {
    if(user.getRoles() == null){
        user.setRoles(new HashSet<>(Arrays.asList(Role.USER)));
    }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.create(user);
    }

    @Override
    @Transactional
    public User updateUser(int id, User user) {
        User u = findById(id);
        u.setEmail(user.getEmail());
        u.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.update(u);
    }

    @Override
    public List<User> showAllUsers() {
        return userDao.getAll();
    }

    @Override
    public User findById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public int deleteByEmail(String email) {
        return userDao.removeById(findByEmail(email).getId());
    }

    @Override
    public int deleteById(int id) {
        return userDao.removeById(id);
    }
    @Override
    @Transactional
    public User assignRole(int id, Role role) {
        User u = findById(id);
        u.getRoles().add(role);
        return userDao.update(u);
    }

}
