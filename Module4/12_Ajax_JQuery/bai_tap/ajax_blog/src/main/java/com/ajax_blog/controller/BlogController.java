package com.ajax_blog.controller;

import com.ajax_blog.model.Blog;
import com.ajax_blog.model.Category;
import com.ajax_blog.service.BlogService;
import com.ajax_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@CrossOrigin
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }


//    @GetMapping(value = "/blogs", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Page<Blog> listBlogs(@PageableDefault(size = 3) Pageable pageable){
//        Page<Blog> blogs = blogService.findByOrderByAuthorDesc(pageable);
//
//        return blogs;
//    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> listBlogs(@RequestParam("pageNumber") String pageNumber) {
        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), 3);

        Page<Blog> blogs = blogService.findByOrderByAuthorDesc(pageable);

        return new ResponseEntity<>(blogs.getContent(), HttpStatus.OK);
    }

    @GetMapping("/blog/create")
    public String getCreatePage(Model model) {
        model.addAttribute("blog", new Blog());

        return "/blog/create";
    }

    @PostMapping("/blog/save")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Successfully added !");

        return "redirect:/blogs";
    }

    @GetMapping("/blog/{id}/edit")
    public String getEditPage(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);

        return "/blog/edit";
    }

    @PostMapping("/blog/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Successfully updated !");

        return "redirect:/blogs";
    }

    @GetMapping("/blog/{id}/delete")
    public String getDeletePage(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);

        return "/blog/delete";
    }

    @PostMapping("/blog/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.deleteById(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Successfully deleted !");

        return "redirect:/blogs";
    }

    @GetMapping("/blog/{id}/detail")
    public String getDetailPage(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);

        return "/blog/detail";
    }

//    @PostMapping(value = "/blog/search", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public List<Blog> searchByAuthor(@RequestParam("inputSearch") String inputSearch){
//        List<Blog> blogs = blogService.findAllByAuthorContaining(inputSearch);
//        return blogs;
//    }

    @PostMapping("/blog/search")
    public ResponseEntity<List<Blog>> searchByAuthor(@RequestParam("inputSearch") String textSearch) {
        return new ResponseEntity<>(blogService.findAllByAuthorContaining(textSearch), HttpStatus.OK);
    }


}
