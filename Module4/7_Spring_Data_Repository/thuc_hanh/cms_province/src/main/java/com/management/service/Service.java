package com.management.service;

import com.management.model.Customer;

import java.util.List;

public interface Service<T> {
    Iterable<T> findAll();

    T findById(Integer id);

    void deleteById(Integer id);

    void save(T t);
}
