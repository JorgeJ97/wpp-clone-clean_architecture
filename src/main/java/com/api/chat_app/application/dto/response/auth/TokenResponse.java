package com.api.chat_app.application.dto.response.auth;

public record TokenResponse(
        String accessToken,
        String refreshToken
) {
}
