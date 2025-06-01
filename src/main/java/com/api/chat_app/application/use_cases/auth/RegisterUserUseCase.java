package com.api.chat_app.application.use_cases.auth;

import com.api.chat_app.application.dto.request.auth.RegisterRequest;
import com.api.chat_app.application.dto.response.auth.AuthResponse;
import com.api.chat_app.application.dto.response.auth.TokenResponse;
import com.api.chat_app.application.mapper.UserDTOMapper;
import com.api.chat_app.application.validator.AuthRequestValidator;
import com.api.chat_app.domain.entity.User;
import com.api.chat_app.domain.exception.UserAlreadyExistException;
import com.api.chat_app.domain.interfaces.service.TokenCreator;
import com.api.chat_app.domain.interfaces.service.UserService;

public class RegisterUserUseCase {
    private final UserService userService;
    private final AuthRequestValidator validator;
    private final TokenCreator tokenService;

    public RegisterUserUseCase(UserService userService, AuthRequestValidator validator, TokenCreator tokenService){
        this.userService = userService;
        this.validator = validator;
        this.tokenService = tokenService;
    }

    public AuthResponse run(RegisterRequest request){
        validator.registerRequestValidate(request);
        if (userService.existUserByEmail(request.getEmail())) throw new UserAlreadyExistException(request.getEmail());
        User newUser = userService.createUser(UserDTOMapper.registerRequestToDomainUser(request));
        var token = tokenService.generateToken(newUser);

        return new AuthResponse(UserDTOMapper.domainUserToUserDetail(newUser),token);

    }
}
