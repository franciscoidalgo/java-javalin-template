package com.frappu.service;

import com.frappu.dto.UserDto;
import com.frappu.model.User;
import com.frappu.repository.UserRepository;

import javax.inject.Inject;

public class UserService {
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserById(Long id) {
        var user = userRepository.findById(id);
        return new UserDto(user.getId());
    }

    public Long createUser(UserDto userDto) {
        User user = new User(userDto.getId());
        userRepository.save(user);
        return user.getId();
    }
}
