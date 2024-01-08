package com.spingsample.backend.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id){
        super("Could not found the user" + id);
    }
}
