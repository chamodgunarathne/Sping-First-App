package com.spingsample.backend.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long id){
        super("Could not found the item" + id);
    }
}