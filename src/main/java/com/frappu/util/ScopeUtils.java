package com.frappu.util;

import com.frappu.config.ScopesEnum;

public class ScopeUtils {
    private ScopeUtils() {}

    public static ScopesEnum getScope() {
        String scopeEnvVar = System.getenv("SCOPE");
        return ScopesEnum.getScopeByValue(scopeEnvVar);
    }
}
