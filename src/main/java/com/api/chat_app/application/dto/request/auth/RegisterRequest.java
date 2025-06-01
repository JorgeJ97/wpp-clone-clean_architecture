package com.api.chat_app.application.dto.request.auth;

public class RegisterRequest extends AuthRequest {
    private final String username;

    public RegisterRequest(String email, String password, String username) {
        super(email, password);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
