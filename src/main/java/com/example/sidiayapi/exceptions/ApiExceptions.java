package com.example.sidiayapi.exceptions;

public class ApiExceptions {
    public static class WrongCredentialsException extends RuntimeException {
    }

    public static class WrongParamsException extends RuntimeException {
    }

    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }

    public static class NotYetHandled extends RuntimeException {
        public NotYetHandled(String message) {
        }
    }
}
