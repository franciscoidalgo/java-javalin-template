package com.frappu.controller;

import io.javalin.http.Context;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiContent;
import io.javalin.openapi.OpenApiResponse;

public class PingController {
    @OpenApi(path = "/ping",
            tags = {"ping"},
            methods = HttpMethod.GET,
            responses = @OpenApiResponse(status = "200", content = @OpenApiContent(from = String.class)))
    public void ping(Context ctx) {
        ctx.result("Ok");
    }
}
