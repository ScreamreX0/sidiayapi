package com.example.sidiayapi.exceptions;

public class NotYetImplementedException extends RuntimeException {
    public NotYetImplementedException(String message) {
        super(message);
    }
    public NotYetImplementedException() {
        super();
    }
}
