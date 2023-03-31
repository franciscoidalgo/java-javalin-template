package com.frappu.controller;

import com.frappu.service.UserService;

import javax.inject.Inject;

public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
