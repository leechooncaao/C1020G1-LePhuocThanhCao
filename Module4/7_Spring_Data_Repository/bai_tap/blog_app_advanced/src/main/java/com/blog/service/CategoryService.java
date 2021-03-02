package com.blog.service;

import com.blog.model.Category;

public interface CategoryService extends Service<Category> {
    Iterable<Category> findAll();
}
