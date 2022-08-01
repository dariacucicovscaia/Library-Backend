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
    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return ("<h1>Hi</h1>");
    }

    @GetMapping("allUsers")
    public List<User> getAllUsers() {
        return userService.showAllUsers();
    }

    @PostMapping("addUser")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("findUserById/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PutMapping("updateUser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }


    @DeleteMapping("delete/{id}")
    public int deleteById(@PathVariable int id) {
        return userService.deleteById(id);
    }


}
