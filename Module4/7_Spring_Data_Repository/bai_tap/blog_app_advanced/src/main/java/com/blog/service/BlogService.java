package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService extends Service<Blog> {
    Page<Blog> findAllByAuthorContaining (String author, Pageable pageable);

}
