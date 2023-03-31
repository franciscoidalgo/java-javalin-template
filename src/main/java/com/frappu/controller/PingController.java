package com.frappu.controller;

import io.javalin.http.Context;

public class PingController {
    public void ping(Context ctx) {
        ctx.result("Ok");
    }
}
