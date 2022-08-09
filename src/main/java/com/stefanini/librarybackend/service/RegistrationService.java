package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.dto.RegistrationRequestDto;

public interface RegistrationService {
    void registerUser(RegistrationRequestDto request);
}
