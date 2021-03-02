package com.management.service;

public interface Service<T> {
    Iterable<T> findAll();

    T findById(Integer id);

    void deleteById(Integer id);

    void save(T t);
}
