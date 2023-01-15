package com.example.sidiayapi.exceptions;

public class ApiExceptions {
    public static class WrongParamsFormatException extends RuntimeException {
        public WrongParamsFormatException() {
        }

        public WrongParamsFormatException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class WrongEmailOrPasswordException extends RuntimeException {
        public WrongEmailOrPasswordException() {
        }

        public WrongEmailOrPasswordException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
