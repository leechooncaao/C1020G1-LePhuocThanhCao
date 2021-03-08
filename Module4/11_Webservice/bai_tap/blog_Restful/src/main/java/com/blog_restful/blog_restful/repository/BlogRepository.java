package com.blog_restful.blog_restful.repository;

import com.blog_restful.blog_restful.model.Blog;
import com.blog_restful.blog_restful.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByCategory(Category category);

}
