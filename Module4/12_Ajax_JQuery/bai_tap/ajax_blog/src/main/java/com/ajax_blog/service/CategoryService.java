package com.ajax_blog.service;


import com.ajax_blog.model.Category;

public interface CategoryService extends Service<Category> {
    Iterable<Category> findAll();
}
