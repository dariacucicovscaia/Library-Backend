package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.ConfirmationToken;

public interface EmailConfirmationTokenService {
    void saveConfirmationToken(ConfirmationToken confirmationToken);
}
