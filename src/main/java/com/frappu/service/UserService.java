package com.frappu.service;

import com.frappu.repository.UserRepository;

import javax.inject.Inject;

public class UserService {
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
