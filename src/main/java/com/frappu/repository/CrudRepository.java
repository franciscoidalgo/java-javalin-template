package com.frappu.repository;

public interface CrudRepository<T, I> {
    T findById(I id);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
}
