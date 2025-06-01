package com.api.chat_app.domain.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String email){
        super(String.format("Already exist a user with this email %s", email));
    }
}
