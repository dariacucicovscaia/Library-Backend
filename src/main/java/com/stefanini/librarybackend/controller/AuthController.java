package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.dto.LoginRequestDto;
import com.stefanini.librarybackend.service.impl.AppUserServiceImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AppUserServiceImpl appUserServiceImpl;

    public AuthController(@Lazy AppUserServiceImpl appUserServiceImpl) {
        this.appUserServiceImpl = appUserServiceImpl;
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDto request) {
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(appUserServiceImpl.login(request));
        } catch (AuthenticationException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Invalid email or password");
        }
    }
}
