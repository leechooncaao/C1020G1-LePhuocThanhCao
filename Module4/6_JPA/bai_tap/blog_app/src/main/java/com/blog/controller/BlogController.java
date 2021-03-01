package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String showListBlogs(Model model){
        List<Blog> blogList = blogService.getListBlogs();
        model.addAttribute("blogList", blogList);

        return "/home";
    }

    @GetMapping("/blog/create")
    public String getCreatePage(Model model){
        model.addAttribute("blog",new Blog());

        return "/create";
    }

    @PostMapping("/blog/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Successfully added !");

        return "redirect:/";
    }

    @GetMapping("/blog/{id}/edit")
    public String getEditPage(@PathVariable int id, Model model){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("editingBlog", blog );

        return "/edit";
    }

    @PostMapping("/blog/update")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Successfully updated !");

        return "redirect:/";
    }

    @GetMapping("/blog/{id}/delete")
    public String getDeletePage(@PathVariable int id,Model model){
        model.addAttribute("blog", blogService.getBlogById(id));

        return "/delete";
    }

    @PostMapping("/blog/delete")
    public String delete(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.removeBlog(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Successfully deleted !");

        return "redirect:/";
    }

    @GetMapping("/blog/{id}/detail")
    public String getDetailPage(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.getBlogById(id));

        return "/detail";
    }


}
