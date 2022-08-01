package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.UserRoleDAO;
import com.stefanini.librarybackend.dao.impl.UserRoleDAOImpl;
import com.stefanini.librarybackend.domain.UserRole;
import com.stefanini.librarybackend.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleDAO<UserRole> userDao;

    public UserRoleServiceImpl(UserRoleDAOImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserRole createUserRole(UserRole user) {
        return userDao.create(user);
    }

    @Override
    public UserRole updateUserRole(UserRole user) {
        return userDao.update(user);
    }

    @Override
    public List<UserRole> showAllUserRoles() {
        return userDao.getAll();
    }

    @Override
    public UserRole findById(int id) {
        return userDao.getById(id);
    }

    @Override
    public UserRole findByEmail(String email) {
        return userDao.findUserRoleByEmail(email);
    }

    @Override
    public int deleteByEmail(String email) {
        return userDao.removeById(userDao.findUserRoleByEmail(email).getId());
    }

    @Override
    public int deleteById(int id) {
        return userDao.removeById(id);
    }
}
