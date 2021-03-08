package com.blog_restful.blog_restful.service;

import java.util.List;

public interface Service<T> {
    List<T> findAll();

    T findById(Integer id);

    void deleteById(Integer id);

    void save(T t);
}
