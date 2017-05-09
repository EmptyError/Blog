package com.yana.home.exceptions;

/**
 * Created by Admin on 02.05.2017.
 */
public class ValidationException extends  RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
