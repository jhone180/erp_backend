package com.erp.erp_backend.quality.exception.exceptions;

public class ObjectNullException extends RuntimeException{

    public ObjectNullException(Object object){
        super(String.format("The object %s cannot be null", object.getClass().getName()));
    }
}
