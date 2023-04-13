package com.frappu.controller;

import com.frappu.dto.UserDto;
import com.frappu.service.UserService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiContent;
import io.javalin.openapi.OpenApiParam;
import io.javalin.openapi.OpenApiRequestBody;
import io.javalin.openapi.OpenApiResponse;

import javax.inject.Inject;

public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @OpenApi(path = "/v1/users",
            tags = {"users"},
            methods = HttpMethod.POST,
            requestBody = @OpenApiRequestBody(required = true, content = @OpenApiContent(from = UserDto.class)),
            responses = @OpenApiResponse(status = "201", content = @OpenApiContent(from = UserDto.class)))
    public void createUser(Context ctx) {
        UserDto userDto = ctx.bodyAsClass(UserDto.class);
        Long userId = userService.createUser(userDto);
        userDto.setId(userId);
        ctx.status(HttpStatus.CREATED);
        ctx.json(userDto);
    }

    @OpenApi(path = "/v1/users/{user_id}",
            tags = {"users"},
            methods = HttpMethod.GET,
            pathParams = @OpenApiParam(name = "user_id", required = true),
            responses = @OpenApiResponse(status = "200", content = @OpenApiContent(from = UserDto.class)))
    public void getUser(Context ctx) {
        Long userId = Long.parseLong(ctx.pathParam("user_id"));
        UserDto userDto = userService.getUserById(userId);
        ctx.json(userDto);
    }
}
