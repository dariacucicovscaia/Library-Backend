package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.impl.UserRoleDAOImpl;
import com.stefanini.librarybackend.domain.UserRole;
import com.stefanini.librarybackend.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleDAOImpl userDao;

    public UserRoleServiceImpl() {
        userDao = new UserRoleDAOImpl();
    }

    public void createUserRole(UserRole user) {
        userDao.create(user);
    }

    @Override
    public void updateUserRole(UserRole user) {
        userDao.update(user);
    }

    @Override
    public List<UserRole> showAllUserRoles() {
        return userDao.getAll();
    }

    @Override
    public UserRole findById(int id) {
        return userDao.get(id);
    }

    @Override
    public UserRole findByEmail(String email) {
        return userDao.findUserRoleByEmail(email);
    }

    @Override
    public void deleteByEmail(String email) {
        userDao.remove(userDao.findUserRoleByEmail(email).getId());
    }

    @Override
    public void deleteById(int id) {
        userDao.remove(id);
    }
}
