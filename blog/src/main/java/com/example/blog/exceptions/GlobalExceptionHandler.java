package com.example.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String messages= ex.getMessage();
        return new ResponseEntity<>(messages, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
       Map<String,String> errors=new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((error) ->{
           String fieldName = ((FieldError) error).getField();
           String defaultMessage = error.getDefaultMessage();
           errors.put(fieldName,defaultMessage);
       });
       return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
    }
}
