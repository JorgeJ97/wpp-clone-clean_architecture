package com.api.chat_app.domain.interfaces.service;

import com.api.chat_app.domain.entity.User;

public interface TokenCreator {
    String generateToken(User user);
    String generateRefreshToken(User user);
}
