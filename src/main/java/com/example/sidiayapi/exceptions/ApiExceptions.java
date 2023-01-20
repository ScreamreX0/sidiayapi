package com.example.sidiayapi.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.Arrays;

public class ApiExceptions {
    public static class WrongParamsFormatException extends RuntimeException {
        public WrongParamsFormatException() {
        }

        public WrongParamsFormatException(String message) {
            super(message);
        }

        public WrongParamsFormatException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class WrongEmailOrPasswordException extends RuntimeException {
        public WrongEmailOrPasswordException() {
        }

        public WrongEmailOrPasswordException(String message) {
            super(message);
        }

        public WrongEmailOrPasswordException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
