package com.api.chat_app.application.use_cases.auth;

import com.api.chat_app.application.dto.request.auth.AuthRequest;
import com.api.chat_app.application.dto.response.auth.AuthResponse;
import com.api.chat_app.application.dto.response.auth.TokenResponse;
import com.api.chat_app.application.mapper.UserDTOMapper;
import com.api.chat_app.application.validator.AuthRequestValidator;
import com.api.chat_app.domain.entity.User;
import com.api.chat_app.domain.exception.IncorrectPasswordException;
import com.api.chat_app.domain.interfaces.service.PasswordEncoder;
import com.api.chat_app.domain.interfaces.service.TokenCreator;
import com.api.chat_app.domain.interfaces.service.UserService;

public class LoginUserUseCase {
    private final UserService userService;
    private final AuthRequestValidator validator;
    private final PasswordEncoder passwordEncoder;
    private final TokenCreator tokenService;

    public LoginUserUseCase(UserService userService,
                            AuthRequestValidator validator,
                            PasswordEncoder passwordEncoder,
                            TokenCreator tokenService) {
        this.userService = userService;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public AuthResponse run(AuthRequest request){
        validator.loginRequestValidate(request);
        User user = userService.getUserByEmail(request.getEmail());
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) throw new IncorrectPasswordException();
        var token = tokenService.generateToken(user);

        return new AuthResponse(UserDTOMapper.domainUserToUserDetail(user), token);
    }
}
