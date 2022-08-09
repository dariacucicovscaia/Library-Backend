package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.dao.impl.UserDAOImpl;
import com.stefanini.librarybackend.domain.Profile;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;
import com.stefanini.librarybackend.dto.RegistrationRequestDto;
import com.stefanini.librarybackend.service.RegistrationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final String EMAIL_ALREADY_TAKEN_MSG = "Email %s taken";

    private final PasswordEncoder passwordEncoder;
    private final UserDAO<User> userDAO;

    public RegistrationServiceImpl(UserDAOImpl userDAOImpl, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAOImpl;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegistrationRequestDto request) {
        User user = userDAO.findUserByEmail(request.getEmail());

        if (user != null) {
            throw new IllegalStateException(String.format(EMAIL_ALREADY_TAKEN_MSG, request.getEmail()));
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User newUser = new User(request.getEmail(), encodedPassword,
                new Profile(request.getFirstName(), request.getLastName(), request.getPhoneNumber()));
        newUser.setRoles(new HashSet<>(Arrays.asList(Role.USER)));

        userDAO.create(newUser);

    }
}
