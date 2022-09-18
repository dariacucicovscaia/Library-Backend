package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Profile;

import java.util.List;

/**
 * Class is used to manage users' profiles
 *
 * @author DCUCICOV
 * @version 0.1
 * @since 0.1
 */
public interface ProfileService {

    /**
     * Create profile.
     *
     * @param user
     * @return profile
     */
    Profile createProfile(Profile user);

    /**
     * Update profile.
     *
     * @param id   of profile
     * @param user new profile data to save
     * @return updated profile
     */
    Profile updateProfile(int id, Profile user);

    /**
     * Get all profiles.
     *
     * @return all profiles
     */
    List<Profile> showAllProfiles();

    /**
     * Get profile by id.
     *
     * @param id of profile to be found
     * @return profile that was found
     */
    Profile findById(int id);

    /**
     * Get profile by email.
     *
     * @param email
     * @return profile
     */
    Profile findByEmail(String email);

    /**
     * Delete profile by email.
     *
     * @param email of profile to be deleted
     * @return id of deleted profile
     */
    int deleteByEmail(String email);

    /**
     * Delete profile by id.
     *
     * @param id of profile to be deleted
     * @return id of deleted profile
     */
    int deleteById(int id);

    /**
     * Get profile by id.
     *
     * @param id of profile to be found
     * @return profile that was found
     */
    Profile getProfileById(int id);

}
