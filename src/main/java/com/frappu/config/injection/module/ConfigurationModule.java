package com.frappu.config.injection.module;

import com.frappu.util.Configuration;
import com.google.inject.AbstractModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationModule extends AbstractModule {
    @Override
    protected void configure() {
        var configuration = new Configuration("application.properties");
        bind(Configuration.class).toInstance(configuration);
        log.info("Configuration loaded");
    }
}
