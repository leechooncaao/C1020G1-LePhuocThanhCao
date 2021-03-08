package com.blog_restful.blog_restful.controller;

import com.blog_restful.blog_restful.model.Category;
import com.blog_restful.blog_restful.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories/")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.findAll();

        if(categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


}
