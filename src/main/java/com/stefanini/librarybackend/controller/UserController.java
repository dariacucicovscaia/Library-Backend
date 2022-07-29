package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;
import com.stefanini.librarybackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("allUsers")
    public List<User> getAllUsers() {
        return userService.showAllUsers();
    }

    @PostMapping("addUser")
    public void addUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("findUserById/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PutMapping("updateUser/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        User u = userService.findById(id);
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        userService.updateUser(u);
    }


    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }


}
