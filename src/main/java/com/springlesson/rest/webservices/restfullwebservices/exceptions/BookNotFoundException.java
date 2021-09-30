package com.springlesson.rest.webservices.restfullwebservices.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}