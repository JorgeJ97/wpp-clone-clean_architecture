package com.api.chat_app.domain.interfaces.service;

public interface TokenManagement <TCookie> {
    TCookie createRefreshTokenCookie(String refreshToken);
    void saveRefreshToken(String refreshToken);

}
