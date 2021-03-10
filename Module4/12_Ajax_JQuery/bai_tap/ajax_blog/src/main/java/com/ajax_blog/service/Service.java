package com.ajax_blog.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service<T> {
    Page<T> findAll(Pageable pageable);

    T findById(Integer id);

    void deleteById(Integer id);

    void save(T t);
}
