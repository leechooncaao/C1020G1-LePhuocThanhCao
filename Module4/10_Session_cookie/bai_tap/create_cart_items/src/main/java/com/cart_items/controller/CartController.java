package com.cart_items.controller;

import com.cart_items.model.Cart;
import com.cart_items.model.Item;
import com.cart_items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@SessionAttributes("cart")
public class CartController {

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String getHomePage(Model model){
        model.addAttribute("items", itemService.findAll());
        return "home";
    }

    @GetMapping("/detail/{id}")
    public String getDetailPage(@PathVariable Integer id, Model model){
        model.addAttribute("item", itemService.findById(id));
        return "detail";
    }

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, Model model, @ModelAttribute("cart") Cart cart){
        Item item = itemService.findById(id);

        cart.addToCart(item);
        model.addAttribute("item", item);
        model.addAttribute("message", "Successfully added !");
        return "detail";
    }

    @GetMapping("/cart")
    public String getCartPage(@ModelAttribute("cart") Cart cart, Model model){
        Map<Item, Integer> cart_item = cart.getCart();
        model.addAttribute("cart_item", cart_item);

        return "cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String removeItem(@ModelAttribute("cart") Cart cart, @PathVariable("id") Integer id){
        cart.removeItem(itemService.findById(id));

        return "redirect:/cart";
    }
}
