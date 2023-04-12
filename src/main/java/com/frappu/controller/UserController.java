package com.frappu.controller;

import com.frappu.dto.UserDto;
import com.frappu.service.UserService;
import io.javalin.http.Context;

import javax.inject.Inject;

public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(Context ctx) {
        UserDto userDto = ctx.bodyAsClass(UserDto.class);
        Long userId = userService.createUser(userDto);
        userDto.setId(userId);
        ctx.json(userDto);
    }

    public void getUser(Context ctx) {
        Long userId = Long.parseLong(ctx.pathParam("user_id"));
        UserDto userDto = userService.getUserById(userId);
        ctx.json(userDto);
    }
}
