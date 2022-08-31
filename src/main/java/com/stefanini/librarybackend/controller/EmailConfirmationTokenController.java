package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.service.EmailConfirmationTokenService;
import com.stefanini.librarybackend.service.impl.EmailConfirmationTokenServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email-confirmation")
public class EmailConfirmationTokenController {

    private final EmailConfirmationTokenService emailConfirmationTokenService;

    public EmailConfirmationTokenController(EmailConfirmationTokenServiceImpl emailConfirmationTokenServiceImpl) {
        this.emailConfirmationTokenService = emailConfirmationTokenServiceImpl;
    }
}
