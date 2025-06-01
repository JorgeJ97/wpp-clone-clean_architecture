package com.api.chat_app.application.validator;

import com.api.chat_app.application.dto.request.auth.AuthRequest;
import com.api.chat_app.application.dto.request.auth.RegisterRequest;
import com.api.chat_app.domain.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class AuthRequestValidator {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private boolean isNotNullOrEmpty(String field){
        return field != null && !field.trim().isEmpty();
    }

    private boolean isValidEmailFormat(String email){
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private boolean isValidPassword(String password){
        return isNotNullOrEmpty(password) && password.length() >= 8;
    }

    private boolean isValidEmail(String email){
        return isNotNullOrEmpty(email) && isValidEmailFormat(email);
    }
    private boolean isValidUsername(String username){
        return isNotNullOrEmpty(username) && username.length() >=3;
    }

    private List<String> basicAuthValidate(AuthRequest request){
        List<String> errors = new ArrayList<>();
        if(!isValidEmail(request.getEmail())) errors.add("Invalid email");
        if(!isValidPassword(request.getPassword())) errors.add("Password must be at least 8 characters");
        return errors;
    }

    public void registerRequestValidate(RegisterRequest request){

        List<String> errors = basicAuthValidate(request);
        if(!isValidUsername(request.getUsername())) {
            errors.add("Username must be at least 3 characters");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    public void loginRequestValidate(AuthRequest request) {
        List<String> errors = basicAuthValidate(request);
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
