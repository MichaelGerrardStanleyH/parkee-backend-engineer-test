package com.parkee.parkee_backend_engineer_test.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<?> handleValidation(ValidationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<?> handleValidation(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
    }



}
