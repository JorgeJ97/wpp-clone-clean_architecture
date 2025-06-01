package com.api.chat_app.domain.exception;

public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException(){
        super("Incorrect password");
    }
}
