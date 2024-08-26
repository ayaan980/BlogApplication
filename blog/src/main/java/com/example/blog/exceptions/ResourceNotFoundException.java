package com.example.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String fieldName;
    long fieldValue;

    public  ResourceNotFoundException(){
        super("Resource not found exception");
    }
}
