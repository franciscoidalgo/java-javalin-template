package com.frappu.config;

import com.frappu.dto.ApiExceptionDto;
import com.frappu.exception.ApiException;
import io.javalin.http.Context;

public class ExceptionHandler {
    public Context handleApiException(ApiException e, Context ctx) {
        return ctx
                .json(new ApiExceptionDto(e.getMessage(), e.getStatusCode()))
                .status(e.getStatusCode());
    }
}
