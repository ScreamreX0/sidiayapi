package com.example.sidiayapi.exceptions;

public class WrongParamsException extends RuntimeException {
    public WrongParamsException(String message) {
        super(message);
    }
    public WrongParamsException() {
        super();
    }
}
