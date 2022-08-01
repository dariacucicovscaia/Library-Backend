package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Profile;

import java.util.List;

public interface ProfileService {
    Profile createProfile(Profile user);
    Profile updateProfile(Profile user);
    List<Profile> showAllProfiles();
    Profile findById(int id);
    Profile findByEmail(String email);
    Profile deleteByEmail(String email);
    Profile deleteById(int id);

}
