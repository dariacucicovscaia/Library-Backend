package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Profile;

import java.util.List;

public interface ProfileService {
    Profile createProfile(Profile user);

    Profile updateProfile(int id, Profile user);

    List<Profile> showAllProfiles();

    Profile findById(int id);

    Profile findByEmail(String email);

    int deleteByEmail(String email);

    int deleteById(int id);

    Profile getProfileById(int id);

}
