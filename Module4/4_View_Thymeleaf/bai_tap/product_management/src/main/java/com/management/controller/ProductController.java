package com.management.controller;

import com.management.model.Product;
import com.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String createProduct(Model model){
        model.addAttribute("product",new Product());

        return "/create";
    }
}
