package com.blog_restful.blog_restful.controller;

import com.blog_restful.blog_restful.model.Blog;
import com.blog_restful.blog_restful.model.Category;
import com.blog_restful.blog_restful.service.BlogService;
import com.blog_restful.blog_restful.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    // Retrieve all blogs
    @GetMapping("/blogs/")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        List<Blog> blogs = blogService.findAll();

        if(blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // Retrieve all blogs by category
    @GetMapping("/blogs/by-category/{id}")
    public ResponseEntity<List<Blog>> getListBlogsByCategory(@PathVariable("id") Integer id){
        Category category = categoryService.findById(id);
        if(category == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<Blog> blogs = blogService.findAllByCategory(category);
        if(blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // Retrieve one blog
    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Integer id){
        Blog blog = blogService.findById(id);

        if(blog == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
