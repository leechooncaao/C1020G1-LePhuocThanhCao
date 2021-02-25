package com.management.controller;

import com.management.model.Product;
import com.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showListProduct(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);

        return "/home";
    }

    @GetMapping("/product/create")
    public String getCreatePage(Model model){
        model.addAttribute("product",new Product());

        return "/create";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        product.setId(productService.getIdProduct());
        productService.create(product);
        redirectAttributes.addFlashAttribute("message", "Successfully created !");

        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String getEditPage(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("editingProduct", product );

        return "/edit";
    }

    @PostMapping("/product/update")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        productService.updateById(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Successfully updated !");

        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String getDeletePage(@PathVariable int id,Model model){
        model.addAttribute("product", productService.findById(id));

        return "/delete";
    }

    @PostMapping("/product/delete")
    public String delete(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        productService.deleteById(product.getId());
        redirectAttributes.addFlashAttribute("message", "Successfully deleted !");

        return "redirect:/";
    }

    @GetMapping("/product/{id}/detail")
    public String getDetailPage(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));

        return "/detail";
    }

}
