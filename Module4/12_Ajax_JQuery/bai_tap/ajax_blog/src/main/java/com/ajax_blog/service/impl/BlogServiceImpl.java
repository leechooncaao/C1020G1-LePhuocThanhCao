package com.ajax_blog.service.impl;

import com.ajax_blog.model.Blog;
import com.ajax_blog.repository.BlogRepository;
import com.ajax_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAllByAuthorContaining(String author, Pageable pageable) {
        return blogRepository.findAllByAuthorContaining(author,pageable);
    }

    @Override
    public Page<Blog> findByOrderByAuthorDesc(Pageable pageable) {
        return blogRepository.findByOrderByAuthorDesc(pageable);
    }

    @Override
    public Page<Blog> findByAuthor(String inputSearch, Pageable pageable) {
        return blogRepository.findByAuthor(inputSearch, pageable);
    }

    @Override
    public List<Blog> findAllByAuthorContaining(String author) {
        return blogRepository.findAllByAuthorContaining(author);
    }


}
