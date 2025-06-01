package com.api.chat_app.domain.interfaces.service;

public interface PasswordEncoder {
    String encode(String password);
    boolean matches(String password, String encodedPassword);
}
