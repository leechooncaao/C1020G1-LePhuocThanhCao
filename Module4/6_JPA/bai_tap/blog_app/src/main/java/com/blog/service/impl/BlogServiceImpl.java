package com.blog.service.impl;

import com.blog.model.Blog;
import com.blog.repository.BlogRepos;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepos blogRepos;

    @Override
    public List<Blog> getListBlogs() {
        return blogRepos.getListBlogs();
    }

    @Override
    public Blog getBlogById(Integer id) {
        return blogRepos.getBlogById(id);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepos.saveBlog(blog);
    }

    @Override
    public void removeBlog(Integer id) {
        blogRepos.removeBlog(id);
    }
}
