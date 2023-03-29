package com.example.sidiayapi.exceptions;

import com.example.sidiayapi.models.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = ApiExceptions.WrongCredentialsException.class)
    public ResponseEntity<ApiError> handleWrongCredentialsException() {
        return new ResponseEntity<>(
                ApiError
                        .builder()
                        .errorMessage("Wrong credentials")
                        .customMessage("Wrong credentials")
                        .build(),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(value = ApiExceptions.WrongParamsException.class)
    public ResponseEntity<ApiError> handleWrongParamsException(
    ) {
        return new ResponseEntity<>(
                ApiError
                        .builder()
                        .errorMessage("Wrong params")
                        .customMessage("Wrong params")
                        .build(),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(value = ApiExceptions.NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(ApiExceptions.NotFoundException e) {
        return new ResponseEntity<>(
                ApiError
                        .builder()
                        .errorMessage(e.getLocalizedMessage())
                        .customMessage(e.getMessage())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = ApiExceptions.NotYetHandled.class)
    public ResponseEntity<ApiError> handleNotYetHandledException(ApiExceptions.NotFoundException e) {
        return new ResponseEntity<>(
                ApiError
                        .builder()
                        .errorMessage(e.getLocalizedMessage())
                        .customMessage(e.getMessage())
                        .build(),
                HttpStatus.NOT_IMPLEMENTED
        );
    }
}
