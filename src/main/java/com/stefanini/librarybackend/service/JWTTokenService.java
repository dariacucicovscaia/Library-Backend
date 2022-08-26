package com.stefanini.librarybackend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface JWTTokenService {
    void refreshToken(HttpServletRequest request, HttpServletResponse response);
}
