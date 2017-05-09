package com.yana.home.exceptions;

/**
 * Created by Admin on 02.05.2017.
 */
public class ResourceConflictException extends  RuntimeException {
    public ResourceConflictException(String message) {
        super(message);
    }
}
