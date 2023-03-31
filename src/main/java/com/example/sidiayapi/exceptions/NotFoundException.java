package com.example.sidiayapi.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException() {
        super();
    }
}
