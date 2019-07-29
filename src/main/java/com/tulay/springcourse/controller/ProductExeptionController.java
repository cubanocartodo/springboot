package com.tulay.springcourse.controller;

import com.tulay.springcourse.component.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExeptionController {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> exeption( ProductNotFoundException exception){

        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
