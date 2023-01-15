package com.example.sidiayapi.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    /**
     * @HTTPStatus 405
     */
    @ExceptionHandler(value = {
            ApiExceptions.WrongParamsFormatException.class,
            NumberFormatException.class,
            NullPointerException.class,
            ClassCastException.class})
    public ResponseEntity<ApiError> handleWrongParamsFormatException(ApiExceptions.WrongParamsFormatException e, HttpServletRequest request) {
        return new ResponseEntity<>(
                ApiError.builder()
                        .errorMessage(e.getLocalizedMessage())
                        .request(request.getRequestURI())
                        .customMessage("Wrong params formatting")
                        .build(),
                HttpStatusCode.valueOf(405)
        );
    }

    /**
     * @HTTPStatus 406
     */
    @ExceptionHandler(value = {ApiExceptions.WrongEmailOrPasswordException.class})
    public ResponseEntity<ApiError> handleWrongEmailOrPasswordException(ApiExceptions.WrongEmailOrPasswordException e, HttpServletRequest request) {
        return new ResponseEntity<>(
                ApiError.builder()
                        .errorMessage(e.getLocalizedMessage())
                        .request(request.getRequestURI())
                        .customMessage("Wrong email or password")
                        .build(),
                HttpStatusCode.valueOf(406)
        );
    }
}
