package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.service.AppTokenService;
import com.stefanini.librarybackend.service.impl.AppTokenServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    private final AppTokenService appTokenService;

    public TokenController(AppTokenServiceImpl appTokenServiceImpl) {
        this.appTokenService = appTokenServiceImpl;
    }

    @GetMapping("/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        appTokenService.refreshToken(request, response);
    }
}
