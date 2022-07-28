package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.impl.ProfileDAOImpl;
import com.stefanini.librarybackend.domain.Profile;
import com.stefanini.librarybackend.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileDAOImpl userDao;

    public ProfileServiceImpl() {
        userDao = new ProfileDAOImpl();
    }

    @Override
    public void createProfile(Profile user) {
        userDao.create(user);
    }

    @Override
    public void updateProfile(Profile user) {
        userDao.update(user);
    }

    @Override
    public List<Profile> showAllProfiles() {
        return userDao.getAll();
    }

    @Override
    public Profile findById(int id) {
        return userDao.get(id);
    }

    @Override
    public Profile findByEmail(String email) {
        return userDao.findProfileByEmail(email);
    }

    @Override
    public void deleteByEmail(String email) {
        userDao.remove(userDao.findProfileByEmail(email).getId());
    }

    @Override
    public void deleteById(int id) {
        userDao.remove(id);
    }
}