package com.api.chat_app.infrastructure.config;

import com.api.chat_app.application.use_cases.auth.LoginUserUseCase;
import com.api.chat_app.application.use_cases.auth.RegisterUserUseCase;
import com.api.chat_app.application.validator.AuthRequestValidator;
import com.api.chat_app.domain.interfaces.service.PasswordEncoder;
import com.api.chat_app.domain.interfaces.service.TokenCreator;
import com.api.chat_app.domain.interfaces.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AuthConfig {


    @Bean
    public AuthRequestValidator authRequestValidator() {
        return new AuthRequestValidator();
    }
    @Bean
    public RegisterUserUseCase registerUserUseCase(UserService userService, AuthRequestValidator validator, TokenCreator tokenService){
        return new RegisterUserUseCase(userService, validator, tokenService);
    }

    @Bean
    public LoginUserUseCase loginUserUseCase(
            UserService userService,
            AuthRequestValidator validator,
            PasswordEncoder passwordEncoder,
            TokenCreator tokenService
    ) {
        return new LoginUserUseCase(userService, validator, passwordEncoder, tokenService);
    }

}
