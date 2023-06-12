package com.ues21.fundacionsoles.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public BaseException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseException(String message, HttpStatus status, String message1) {
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
