package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.BlogService;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/blogs")
    public String listBlogs(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam("s") Optional<String> s, Principal principal){
        Page<Blog> blogs;
        if(s.isPresent()){
            blogs = blogService.findAllByAuthorContaining(s.get(), pageable);
        } else {
            blogs = blogService.findByOrderByAuthorDesc(pageable);
        }
        model.addAttribute("blogs", blogs);

        return "/blog/list";
    }

    @GetMapping("/customerRole")
    public String withoutLogin(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam("s") Optional<String> s, Principal principal){
        Page<Blog> blogs;
        if(s.isPresent()){
            blogs = blogService.findAllByAuthorContaining(s.get(), pageable);
        } else {
            blogs = blogService.findByOrderByAuthorDesc(pageable);
        }
        model.addAttribute("blogs", blogs);

        return "/blog/list";
    }

    @GetMapping("/blog/create")
    public String getCreatePage(Model model){
        model.addAttribute("blog", new Blog());

        return "/blog/create";
    }

    @PostMapping("/blog/save")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Successfully added !");

        return "redirect:/blogs";
    }

    @GetMapping("/blog/{id}/edit")
    public String getEditPage(@PathVariable Integer id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);

        return "/blog/edit";
    }

    @PostMapping("/blog/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Successfully updated !");

        return "redirect:/blogs";
    }

    @GetMapping("/blog/{id}/delete")
    public String getDeletePage(@PathVariable Integer id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);

        return "/blog/delete";
    }

    @PostMapping("/blog/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.deleteById(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Successfully deleted !");

        return "redirect:/blogs";
    }

    @GetMapping("/blog/{id}/detail")
    public String getDetailPage(@PathVariable Integer id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);

        return "/blog/detail";
    }


}
