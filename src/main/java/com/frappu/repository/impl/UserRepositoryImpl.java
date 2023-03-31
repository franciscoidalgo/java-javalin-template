package com.frappu.repository.impl;

import com.frappu.dao.Dao;
import com.frappu.model.User;
import com.frappu.repository.UserRepository;

import javax.inject.Inject;

public class UserRepositoryImpl implements UserRepository {
    private final Dao<User, Long> dao;

    @Inject
    public UserRepositoryImpl(Dao<User, Long> dao) {
        this.dao = dao;
    }

    @Override
    public User findById(Long id) {
        return dao.findById(id, User.class);
    }

    @Override
    public void save(User entity) {
        dao.save(entity);
    }

    @Override
    public void update(User entity) {
        dao.update(entity);
    }

    @Override
    public void delete(User entity) {
        dao.delete(entity);
    }
}
