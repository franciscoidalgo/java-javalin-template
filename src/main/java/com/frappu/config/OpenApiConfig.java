package com.frappu.config;

import io.javalin.openapi.plugin.OpenApiPluginConfiguration;

public class OpenApiConfig {
    private OpenApiConfig() {
    }

    public static OpenApiPluginConfiguration get() {
        return new OpenApiPluginConfiguration()
                .withDefinitionConfiguration((ver, def) -> {
                    def.withOpenApiInfo((openApiInfo -> {
                        openApiInfo.setTitle("Javalin Template");
                    }));
                });
    }
}
