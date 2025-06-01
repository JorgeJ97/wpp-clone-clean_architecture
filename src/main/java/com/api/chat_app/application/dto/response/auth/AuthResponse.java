package com.api.chat_app.application.dto.response.auth;

public record AuthResponse(
        UserDetail user,
        String token
) {
}
