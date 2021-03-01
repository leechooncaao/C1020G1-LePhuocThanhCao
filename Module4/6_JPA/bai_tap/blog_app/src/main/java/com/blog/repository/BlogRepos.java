package com.blog.repository;

import com.blog.model.Blog;

import java.util.List;

public interface BlogRepos {
    List<Blog> getListBlogs();

    Blog getBlogById(Integer id);

    void saveBlog(Blog blog);

    void removeBlog(Integer id);
}
