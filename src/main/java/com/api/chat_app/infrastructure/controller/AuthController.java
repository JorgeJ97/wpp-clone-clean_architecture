package com.api.chat_app.infrastructure.controller;

import com.api.chat_app.application.dto.request.auth.AuthRequest;
import com.api.chat_app.application.dto.request.auth.RegisterRequest;
import com.api.chat_app.application.dto.response.auth.AuthResponse;
import com.api.chat_app.application.mapper.UserDTOMapper;
import com.api.chat_app.application.use_cases.auth.LoginUserUseCase;
import com.api.chat_app.application.use_cases.auth.RegisterUserUseCase;
import com.api.chat_app.domain.interfaces.service.TokenManagement;
import com.api.chat_app.infrastructure.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RegisterUserUseCase registerUserUseCase;
    private  final LoginUserUseCase loginUserUseCase;
    private final JwtUtils jwtUtils;
    private final TokenManagement <ResponseCookie> tokenService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
            AuthResponse newUser = registerUserUseCase.run(request);
            final var refreshToken = jwtUtils.generateRefreshToken(UserDTOMapper.UserDetailToDomainUser(newUser.user()));
            tokenService.saveRefreshToken(refreshToken);
            ResponseCookie refreshTokenCookie = tokenService.createRefreshTokenCookie(refreshToken);

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
                    .body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
            AuthResponse user = loginUserUseCase.run(request);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            final var refreshToken = jwtUtils.generateRefreshToken(UserDTOMapper.UserDetailToDomainUser(user.user()));

            tokenService.saveRefreshToken(refreshToken);
            ResponseCookie refreshTokenCookie = tokenService.createRefreshTokenCookie(refreshToken);

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
                    .body(user);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello world");
    }
}
