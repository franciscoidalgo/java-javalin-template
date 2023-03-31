package com.frappu.config;

import lombok.Getter;

import java.util.Arrays;

public enum ScopesEnum {
    LOCAL("local"), TEST("test"), PROD("prod");

    @Getter
    private final String value;

    ScopesEnum(String value) {
        this.value = value;
    }

    public static ScopesEnum getScopeByValue(String value) {
        return Arrays.stream(values())
                .filter(e -> e.value.equals(value))
                .findAny().orElse(LOCAL);
    }
}
