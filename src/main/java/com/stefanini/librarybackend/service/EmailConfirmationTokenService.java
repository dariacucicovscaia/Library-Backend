package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.ConfirmationToken;

/**
 * This interface perform operations with email confirmation token that should be created after registration.
 * After saving confirmation token the user will be inactive.
 * That means that user cannot log in account before he will activate his account with token
 * @author dcuciuc
 * @since 0.1
 * @version 0.1
 */
public interface EmailConfirmationTokenService {
    void saveConfirmationToken(ConfirmationToken confirmationToken);
}
