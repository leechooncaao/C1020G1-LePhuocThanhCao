package com.blog.service;

import com.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getListBlogs();

    Blog getBlogById(Integer id);

    void saveBlog(Blog blog);

    void removeBlog(Integer id);
}
