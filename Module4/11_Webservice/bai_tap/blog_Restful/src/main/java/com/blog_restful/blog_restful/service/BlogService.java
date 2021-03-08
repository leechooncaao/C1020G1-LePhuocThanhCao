package com.blog_restful.blog_restful.service;

import com.blog_restful.blog_restful.model.Blog;
import com.blog_restful.blog_restful.model.Category;

import java.util.List;

public interface BlogService extends Service<Blog> {
    List<Blog> findAllByCategory(Category category);
}
