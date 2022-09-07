package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.ConfirmationToken;
import com.stefanini.librarybackend.domain.enums.ConfirmationTokenStatus;
import com.stefanini.librarybackend.dto.RegistrationRequestDto;
import com.stefanini.librarybackend.service.impl.exception.InvalidTokenException;
import org.springframework.http.ResponseEntity;

/**
 * This interface perform operations with email confirmation token that should be created after registration.
 * After saving confirmation token the user will be inactive.
 * That means that user cannot log in account before he will activate his account with token
 * @author dcuciuc
 * @since 0.1
 * @version 0.1
 */
public interface EmailConfirmationTokenService {

    /**
     * Methods saves generated confirmation token in database
     * @param confirmationToken that should be generated in {@link RegistrationService#registerUser(RegistrationRequestDto) registerUser} method
     */
    void saveConfirmationToken(ConfirmationToken confirmationToken);

    ConfirmationTokenStatus confirmToken(String token) throws InvalidTokenException;
}
