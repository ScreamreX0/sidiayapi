package com.example.sidiayapi.exceptions;

public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException(String message) {
        super(message);
    }
    public WrongCredentialsException() {
        super();
    }
}
