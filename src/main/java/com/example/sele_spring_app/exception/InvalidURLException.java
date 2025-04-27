package com.example.sele_spring_app.exception;

public class InvalidURLException extends RuntimeException {
    public InvalidURLException(String message) {
        super(message);
    }
}