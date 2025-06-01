package com.api.chat_app.application.dto.response.auth;

public record UserDetail (
        String id,
        String username,
        String email,
        String image
) { }
