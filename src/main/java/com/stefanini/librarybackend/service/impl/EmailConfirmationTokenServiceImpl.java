package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.EmailConfirmationTokenDAO;
import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.dao.impl.EmailConfirmationTokenDAOImpl;
import com.stefanini.librarybackend.dao.impl.UserDAOImpl;
import com.stefanini.librarybackend.domain.ConfirmationToken;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.ConfirmationTokenStatus;
import com.stefanini.librarybackend.email.EmailSenderService;
import com.stefanini.librarybackend.service.EmailConfirmationTokenService;
import com.stefanini.librarybackend.service.impl.exception.InvalidTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.stefanini.librarybackend.domain.enums.ConfirmationTokenStatus.*;

@Slf4j
@Service
public class EmailConfirmationTokenServiceImpl implements EmailConfirmationTokenService {

    private final EmailConfirmationTokenDAO<ConfirmationToken> emailConfirmationTokenDAO;
    private final UserDAO<User> userDAO;
    private final EmailSenderService emailSenderService;

    public EmailConfirmationTokenServiceImpl(EmailConfirmationTokenDAOImpl emailConfirmationTokenDAOImpl,
                                             UserDAOImpl userDAOImpl, EmailSenderService emailSenderService) {
        this.emailConfirmationTokenDAO = emailConfirmationTokenDAOImpl;
        this.userDAO = userDAOImpl;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        emailConfirmationTokenDAO.create(confirmationToken);
    }

    @Override
    public ConfirmationTokenStatus confirmToken(String token) throws InvalidTokenException {
        ConfirmationToken confirmationToken = emailConfirmationTokenDAO.findByToken(token);
        verifyToken(confirmationToken);

        if (confirmationToken.getStatus() == CONFIRMED) {
            return WAS_ALREADY_CONFIRMED;
        }

        confirmationToken.setConfirmedAt(LocalDateTime.now());
        confirmationToken.setStatus(CONFIRMED);
        confirmationToken.getUser().setConfirmedByEmail(true);

        userDAO.update(confirmationToken.getUser());
        emailConfirmationTokenDAO.update(confirmationToken);
        return confirmationToken.getStatus();
    }

    @Override
    public ConfirmationTokenStatus sendNewToken(String token) throws InvalidTokenException {
        ConfirmationToken oldConfirmationToken = emailConfirmationTokenDAO.findByToken(token);

        if (oldConfirmationToken == null) {
            log.error("Token not found");
            throw new InvalidTokenException("Token not found");
        }

        String newToken = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = ConfirmationToken.createConfirmationToken(newToken, oldConfirmationToken.getUser());

        emailConfirmationTokenDAO.create(confirmationToken);
        log.info("Email confirmation token saved in database");

        String link = "http://localhost:3000/email-confirmation/" + token;
        emailSenderService.sendMail(
                confirmationToken.getUser().getEmail(),
                "Activate your account by this link - " + link + "\n Link will expired in 15 minutes",
                "Confirm your email"
        );

        return confirmationToken.getStatus();
    }

    private void verifyToken(ConfirmationToken confirmationToken) throws InvalidTokenException {
        if (confirmationToken == null) {
            log.error("Token not found");
            throw new InvalidTokenException("Token not found");
        }

        if (confirmationToken.getStatus() == EXPIRED) {
            log.error("Token is expired");
            throw new InvalidTokenException("Token is expired");
        }

        boolean isExpired = LocalDateTime.now().isAfter(confirmationToken.getExpiresAt());
        if (isExpired) {
            log.error("Token is expired");
            confirmationToken.setStatus(EXPIRED);
            throw new InvalidTokenException("Token is expired");
        }
    }
}
