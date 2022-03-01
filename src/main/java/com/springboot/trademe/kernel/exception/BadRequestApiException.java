package com.springboot.trademe.kernel.exception;

import org.springframework.http.HttpStatus;

public class BadRequestApiException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public BadRequestApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BadRequestApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
