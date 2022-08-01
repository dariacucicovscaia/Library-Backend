package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.ProfileDAO;
import com.stefanini.librarybackend.dao.impl.ProfileDAOImpl;
import com.stefanini.librarybackend.domain.Profile;
import com.stefanini.librarybackend.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileDAO<Profile> profileDao;

    public ProfileServiceImpl(ProfileDAOImpl profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public Profile createProfile(Profile user) {
        return profileDao.create(user);
    }

    @Override
    public Profile updateProfile(Profile user) {
        return profileDao.update(user);
    }

    @Override
    public List<Profile> showAllProfiles() {
        return profileDao.getAll();
    }

    @Override
    public Profile findById(int id) {
        return profileDao.getById(id);
    }

    @Override
    public Profile findByEmail(String email) {
        return profileDao.findProfileByEmail(email);
    }

    @Override
    public int deleteByEmail(String email) {
        return profileDao.removeById(profileDao.findProfileByEmail(email).getId());
    }

    @Override
    public int deleteById(int id) {
        return profileDao.removeById(id);
    }
}