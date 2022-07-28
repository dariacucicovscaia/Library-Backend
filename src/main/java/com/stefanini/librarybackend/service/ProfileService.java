package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Profile;

import java.util.List;

public interface ProfileService {
    void createProfile(Profile user);
    void updateProfile(Profile user);
    List<Profile> showAllProfiles();
    Profile findById(int id);
    Profile findByEmail(String email);
    void deleteByEmail(String email);
    void deleteById(int id);

}
