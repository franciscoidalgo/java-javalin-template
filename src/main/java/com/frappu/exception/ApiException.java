package com.frappu.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private final Integer statusCode;

    public ApiException(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public ApiException(String message, Integer statusCode, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }
}
