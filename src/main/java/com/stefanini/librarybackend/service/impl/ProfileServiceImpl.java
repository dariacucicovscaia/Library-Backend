package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.ProfileDAO;
import com.stefanini.librarybackend.dao.impl.ProfileDAOImpl;
import com.stefanini.librarybackend.domain.Profile;
import com.stefanini.librarybackend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileDAO<Profile> profileDao;

    public ProfileServiceImpl(ProfileDAOImpl profileDao) {
        this.profileDao =profileDao;
    }
    @Override
    public void createProfile(Profile user) {
        profileDao.create(user);
    }

    @Override
    public void updateProfile(Profile user) {
        profileDao.update(user);
    }

    @Override
    public List<Profile> showAllProfiles() {
        return profileDao.getAll();
    }

    @Override
    public Profile findById(int id) {
        return profileDao.get(id);
    }

    @Override
    public Profile findByEmail(String email) {
        return profileDao.findProfileByEmail(email);
    }

    @Override
    public void deleteByEmail(String email) {
        profileDao.remove(profileDao.findProfileByEmail(email).getId());
    }

    @Override
    public void deleteById(int id) {
        profileDao.remove(id);
    }
}