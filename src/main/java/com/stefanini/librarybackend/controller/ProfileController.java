package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Profile;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.service.impl.ProfileServiceImpl;
import com.stefanini.librarybackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    ProfileServiceImpl profileService;

    public ProfileController(ProfileServiceImpl profileService) {
        this.profileService = profileService;
    }

    @PutMapping("updateProfile/{id}")
    public void updateProfile(@PathVariable int id, @RequestBody Profile user) {
        Profile u = profileService.findById(id);
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setPhoneNumber(user.getPhoneNumber());
    }
}
