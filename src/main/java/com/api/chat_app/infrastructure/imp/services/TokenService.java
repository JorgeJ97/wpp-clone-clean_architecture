package com.api.chat_app.infrastructure.imp.services;

import com.api.chat_app.domain.interfaces.service.TokenManagement;
import com.api.chat_app.infrastructure.persistence.interfaces.TokenRepository;
import com.api.chat_app.infrastructure.persistence.models.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService implements TokenManagement <ResponseCookie>{
    private final TokenRepository tokenRepository;

    @Override
    public ResponseCookie createRefreshTokenCookie(String refreshToken) {
        return ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true)
                .secure(true)
                .path("/api/auth/refresh")
                .sameSite("Strict")
                .maxAge(Duration.ofDays(7))
                .build();

    }

    @Override
    public void saveRefreshToken(String refreshToken) {
        tokenRepository.save(
                Token.builder()
                        .token(refreshToken)
                        .build()
        );
    }

    public void deleteAllTokensByUserId(String userId){
        tokenRepository.deleteByUserId(userId);
    }


}
