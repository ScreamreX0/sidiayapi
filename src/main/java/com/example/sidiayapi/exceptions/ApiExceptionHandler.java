package com.example.sidiayapi.exceptions;

import com.example.sidiayapi.models.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    /**
     * @HTTPStatus 450
     */
    @ExceptionHandler(value = {
            ApiExceptions.WrongParamsFormatException.class,
            NumberFormatException.class,
            NullPointerException.class,
            ClassCastException.class,
            ValidationException.class})
    public ResponseEntity<ApiError> handleWrongParamsFormatException(ApiExceptions.WrongParamsFormatException e, HttpServletRequest request) {
        return new ResponseEntity<>(
                ApiError.builder()
                        .errorMessage(e.getLocalizedMessage())
                        .request(request.getRequestURI())
                        .customMessage("Wrong params formatting")
                        .build(),
                HttpStatusCode.valueOf(450)
        );
    }

    /**
     * @HTTPStatus 451
     */
    @ExceptionHandler(value = {ApiExceptions.WrongEmailOrPasswordException.class})
    public ResponseEntity<ApiError> handleWrongEmailOrPasswordException(ApiExceptions.WrongEmailOrPasswordException e, HttpServletRequest request) {
        return new ResponseEntity<>(
                ApiError.builder()
                        .errorMessage(e.getLocalizedMessage())
                        .request(request.getRequestURI())
                        .customMessage("Wrong email or password")
                        .build(),
                HttpStatusCode.valueOf(451)
        );
    }
}
