package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.UserRole;
import com.stefanini.librarybackend.domain.enums.Role;
import com.stefanini.librarybackend.service.impl.UserRoleServiceImpl;
import com.stefanini.librarybackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRoleController {

    UserRoleServiceImpl userroleservice;

    public UserRoleController(UserRoleServiceImpl userroleservice) {
        this.userroleservice = userroleservice;
    }

//    @PostMapping("addUserRole/{role}")
//    public void addUserRole(@PathVariable Role role, @RequestBody User user){
//        user.getUserRole().add(role);
//        userroleservice.updateUserRole();
//    }

}
