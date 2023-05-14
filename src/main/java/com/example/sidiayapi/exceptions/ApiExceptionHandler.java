package com.example.sidiayapi.exceptions;

import com.example.sidiayapi.models.Response;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = WrongCredentialsException.class)
    public ResponseEntity<Response> handleWrongCredentialsException(WrongCredentialsException e) {
        return getResponseEntity("Wrong credentials exception", e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {WrongParamsException.class})
    public ResponseEntity<Response> handleWrongParamsException(WrongParamsException e) {
        return getResponseEntity("Wrong params exception", e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Response> handleNotFoundException(NotFoundException e) {
        return getResponseEntity("Not found exception", e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NotYetImplementedException.class)
    public ResponseEntity<Response> handleNotYetHandledException(NotYetImplementedException e) {
        return getResponseEntity("Not yet implemented exception", e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Response> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return getResponseEntity("Data integrity violation exception", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Response> handleEntityNotFoundException(EntityNotFoundException e) {
        return getResponseEntity("Entity not found exception", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Response> getResponseEntity(String defaultMessage, String errorMessage, HttpStatus httpStatus) {
        return new ResponseEntity<>(new Response(errorMessage == null ? defaultMessage : defaultMessage + ": " + errorMessage), httpStatus);
    }
}
