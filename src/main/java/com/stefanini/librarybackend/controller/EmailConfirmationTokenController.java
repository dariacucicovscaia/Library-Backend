package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.service.EmailConfirmationTokenService;
import com.stefanini.librarybackend.service.impl.EmailConfirmationTokenServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email-confirmation")
public class EmailConfirmationTokenController {

    private final EmailConfirmationTokenService emailConfirmationTokenService;

    public EmailConfirmationTokenController(EmailConfirmationTokenServiceImpl emailConfirmationTokenServiceImpl) {
        this.emailConfirmationTokenService = emailConfirmationTokenServiceImpl;
    }

    @GetMapping("/confirm")
    public ResponseEntity<?> confirmEmail(@RequestParam("token") String token) {
        return emailConfirmationTokenService.confirmToken(token);
    }
}
