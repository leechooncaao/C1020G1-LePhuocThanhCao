package com.ajax_blog.service;

import com.ajax_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService extends Service<Blog> {
    Page<Blog> findAllByAuthorContaining (String author, Pageable pageable);

    Page<Blog> findByOrderByAuthorDesc (Pageable pageable);

    Page<Blog> findByAuthor(String inputSearch, Pageable pageable);

    List<Blog> findAllByAuthorContaining(String author);
}
