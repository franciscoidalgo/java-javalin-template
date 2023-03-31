package com.frappu.dto;

public class ApiExceptionDto {
    String errorMessage;
    Integer statusCode;

    public ApiExceptionDto(String errorMessage, Integer statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
}
