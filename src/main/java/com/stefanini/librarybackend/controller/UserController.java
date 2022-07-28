package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userservice;

    public UserController(UserServiceImpl userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/allUsers")//          localhost:3306/allUsers
    public String test(Model model) {
        model.addAttribute("users", userservice.showAllUsers());
        return "/allUsers";
    }

}
