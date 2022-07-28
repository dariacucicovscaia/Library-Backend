package com.stefanini.librarybackend.service.impl;


import com.stefanini.librarybackend.dao.impl.UserDAOImpl;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserDAOImpl userDao;

    public UserServiceImpl() {
        userDao = new UserDAOImpl();
    }

    @Override
    public void createUser(User user) {
        userDao.create(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> showAllUsers() {
        return userDao.getAll();
    }

    @Override
    public User findById(int id) {
        return userDao.get(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public void deleteByEmail(String email) {
        userDao.remove(findByEmail(email).getId());
    }

    @Override
    public void deleteById(int id) {
        userDao.remove(id);
    }

}
