package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.EmailConfirmationTokenDAO;
import com.stefanini.librarybackend.dao.impl.EmailConfirmationTokenDAOImpl;
import com.stefanini.librarybackend.domain.ConfirmationToken;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.ConfirmationTokenStatus;
import com.stefanini.librarybackend.service.EmailConfirmationTokenService;
import com.stefanini.librarybackend.service.impl.exception.InvalidTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.stefanini.librarybackend.domain.enums.ConfirmationTokenStatus.*;

@Slf4j
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
    public ResponseEntity<?> confirmToken(String token) throws InvalidTokenException {
        ConfirmationToken confirmationToken = emailConfirmationTokenDAO.findByToken(token);
        verifyToken(confirmationToken);
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        confirmationToken.setStatus(CONFIRMED);
        confirmationToken.getUser().setConfirmedByEmail(true);
        return null;
    }

    private void verifyToken(ConfirmationToken confirmationToken) throws InvalidTokenException {
        if (confirmationToken == null) {
            log.error("Token not found");
            throw new InvalidTokenException("Token not found");
        }

        if (confirmationToken.getStatus() == CONFIRMED) {
            log.error("Token is already confirmed");
            throw new InvalidTokenException("Token is already confirmed");
        }

        if (confirmationToken.getExpiresAt() != null) {
            log.error("Token is expired");
            confirmationToken.setStatus(EXPIRED);
            throw new InvalidTokenException("Token is expired");
        }
    }
}
