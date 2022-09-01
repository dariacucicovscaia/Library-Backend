package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.EmailConfirmationTokenDAO;
import com.stefanini.librarybackend.dao.impl.EmailConfirmationTokenDAOImpl;
import com.stefanini.librarybackend.domain.ConfirmationToken;
import com.stefanini.librarybackend.service.EmailConfirmationTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmailConfirmationTokenServiceImpl implements EmailConfirmationTokenService {

    private final EmailConfirmationTokenDAO<ConfirmationToken> emailConfirmationTokenDAO;

    public EmailConfirmationTokenServiceImpl(EmailConfirmationTokenDAOImpl emailConfirmationTokenDAOImpl) {
        this.emailConfirmationTokenDAO = emailConfirmationTokenDAOImpl;
    }

    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        emailConfirmationTokenDAO.create(confirmationToken);
    }

    @Override
    public ResponseEntity<?> confirmToken(String token) {
        return null;
    }
}
