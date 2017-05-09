package com.yana.home.controllers;

import com.yana.home.exceptions.ResourceConflictException;
import com.yana.home.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Admin on 02.05.2017.
 */
@ControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler(ValidationException.class)
    ResponseEntity<String> validationExceptionHandler(ValidationException ex){
        return  new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
@ExceptionHandler(ReflectiveOperationException.class)
    ResponseEntity<String>resourceConflictExceptionHandler(ResourceConflictException ex){
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

    }

}
