package com.api.chat_app.infrastructure.imp.services;

import com.api.chat_app.domain.interfaces.service.PasswordEncoder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordEncoderImp implements PasswordEncoder {
    private final BCryptPasswordEncoder encoder;

    @PostConstruct
    public void init() {
        System.out.println("PasswordEncoderImp initialized with: ");
        System.out.println("BCryptPasswordEncoder: " + encoder.getClass().getName());
    }

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean matches(String password, String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }
}
