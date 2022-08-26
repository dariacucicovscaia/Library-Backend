package com.stefanini.librarybackend.controller;



import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;
import com.stefanini.librarybackend.service.impl.UserServiceImpl;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/find/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PutMapping("/update/{id}")
   // @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PutMapping("/assignRole/{id}/{role}")
   @PreAuthorize("hasAnyAuthority('ADMIN')")
    public User assignRole(@PathVariable int id, @PathVariable Role role) {
        return userService.assignRole(id, role);
    }

    @DeleteMapping("/delete/{id}")
 //   @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public int deleteById(@PathVariable int id) {
        return  userService.deleteById(id);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public List<User> getAllUsers() {
        return userService.showAllUsers();
    }

}

