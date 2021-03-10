package com.ajax_blog.repository;

import com.ajax_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    Page<Blog> findAllByAuthorContaining (String author, Pageable pageable);

    Page<Blog> findByOrderByAuthorDesc (Pageable pageable);

    Page<Blog> findByAuthor(String inputSearch, Pageable pageable);
//    Page<Blog> findByOrd (Pageable pageable);

    List<Blog> findAllByAuthor(String author);
}
