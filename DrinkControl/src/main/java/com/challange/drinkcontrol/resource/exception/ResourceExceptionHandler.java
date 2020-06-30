package com.challange.drinkcontrol.resource.exception;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<DefaultError> objectNotFound(ObjectNotFoundException e,
                                                       HttpServletRequest request) {
        DefaultError erro = new DefaultError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DefaultError> dataIntegrityViolation(DataIntegrityViolationException e,
                                                               HttpServletRequest request) {
        DefaultError erro = new DefaultError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultError> validation(MethodArgumentNotValidException e,
                                                   HttpServletRequest request) {
        ValidationError error = new ValidationError(HttpStatus.NOT_FOUND.value(), "Validation error");
        for (FieldError fe : e.getBindingResult().getFieldErrors()) {
            error.addError(fe.getField(), fe.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
