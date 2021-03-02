package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String listCategory(Model model, @PageableDefault(size = 5)Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable);
        model.addAttribute("categoryList", categories);

        return "/category/list";
    }

    @GetMapping("/category/create")
    public String getCreatePage(Model model){
        model.addAttribute("category", new Category());

        return "/category/create";
    }

    @PostMapping("/category/save")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Successfully added !");

        return "redirect:/categories";
    }

    @GetMapping("/category/{id}/edit")
    public String getEditPage(@PathVariable Integer id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);

        return "/category/edit";
    }

    @PostMapping("/category/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Successfully updated !");

        return "redirect:/categories";
    }

    @GetMapping("/category/{id}/delete")
    public String getDeletePage(@PathVariable Integer id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);

        return "/category/delete";
    }

    @PostMapping("/category/delete")
    public String delete(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.deleteById(category.getId());
        redirectAttributes.addFlashAttribute("message", "Successfully deleted !");

        return "redirect:/categories";
    }
}
