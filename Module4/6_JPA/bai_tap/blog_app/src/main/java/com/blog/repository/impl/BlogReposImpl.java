package com.blog.repository.impl;

import com.blog.model.Blog;
import com.blog.repository.BlogRepos;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class BlogReposImpl implements BlogRepos {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> getListBlogs() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog getBlogById(Integer id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b where  b.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void saveBlog(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void removeBlog(Integer id) {
        Blog blog = getBlogById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }
}
