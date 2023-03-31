package com.frappu.config.injection.module;

import com.frappu.repository.UserRepository;
import com.frappu.repository.impl.UserRepositoryImpl;
import com.google.inject.AbstractModule;

public class RepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserRepository.class).to(UserRepositoryImpl.class).asEagerSingleton();
    }
}
