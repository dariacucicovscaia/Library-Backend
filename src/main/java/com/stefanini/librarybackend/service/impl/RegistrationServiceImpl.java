package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.dao.impl.UserDAOImpl;
import com.stefanini.librarybackend.domain.ConfirmationToken;
import com.stefanini.librarybackend.domain.Profile;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;
import com.stefanini.librarybackend.dto.RegistrationRequestDto;
import com.stefanini.librarybackend.service.EmailConfirmationTokenService;
import com.stefanini.librarybackend.service.RegistrationService;
import com.stefanini.librarybackend.service.impl.exception.EmailAlreadyTakenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final String EMAIL_ALREADY_TAKEN_MSG = "Email %s taken";

    private final PasswordEncoder passwordEncoder;
    private final UserDAO<User> userDAO;
    private final EmailConfirmationTokenService emailConfirmationTokenService;

    public RegistrationServiceImpl(UserDAOImpl userDAOImpl, PasswordEncoder passwordEncoder,
                                   EmailConfirmationTokenServiceImpl emailConfirmationTokenServiceImpl) {
        this.userDAO = userDAOImpl;
        this.passwordEncoder = passwordEncoder;
        this.emailConfirmationTokenService = emailConfirmationTokenServiceImpl;
    }

    @Override
    public void registerUser(RegistrationRequestDto request) {
        User user = userDAO.findUserByEmail(request.getEmail());

        if (user != null) {
            log.error(String.format(EMAIL_ALREADY_TAKEN_MSG, user.getEmail()));
            throw new EmailAlreadyTakenException();
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User newUser = new User(request.getEmail(), encodedPassword,
                new Profile(request.getFirstName(), request.getLastName(), request.getPhoneNumber()));
        newUser.setRoles(new HashSet<>(Arrays.asList(Role.USER)));

        userDAO.create(newUser);


        /*String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                newUser
        );

        emailConfirmationTokenService.saveConfirmationToken(confirmationToken);*/
    }
}
