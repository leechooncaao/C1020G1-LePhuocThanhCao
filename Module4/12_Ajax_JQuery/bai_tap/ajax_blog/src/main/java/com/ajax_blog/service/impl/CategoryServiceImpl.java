package com.ajax_blog.service.impl;

import com.ajax_blog.model.Category;
import com.ajax_blog.repository.CategoryRepository;
import com.ajax_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }


    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
