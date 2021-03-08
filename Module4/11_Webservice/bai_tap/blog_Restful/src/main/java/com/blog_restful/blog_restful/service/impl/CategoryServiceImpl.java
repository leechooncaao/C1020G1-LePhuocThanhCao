package com.blog_restful.blog_restful.service.impl;

import com.blog_restful.blog_restful.model.Category;
import com.blog_restful.blog_restful.repository.CategoryRepository;
import com.blog_restful.blog_restful.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
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
}
