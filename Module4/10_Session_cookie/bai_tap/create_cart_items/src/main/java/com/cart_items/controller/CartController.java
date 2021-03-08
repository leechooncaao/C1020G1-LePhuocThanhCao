package com.cart_items.controller;

import com.cart_items.model.Cart;
import com.cart_items.model.Item;
import com.cart_items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        model.addAttribute("items", itemService.getListItem());
        return "home";
    }

    @GetMapping("/detail/{id}")
    public String getDetailPage(@PathVariable int id, Model model){
        model.addAttribute("item", itemService.findItemById(id));
        return "detail";
    }

    @PostMapping("/add")
    public String addToCart(@ModelAttribute("item") Item item,@RequestParam("quantity") int quantity, Model model, @ModelAttribute("cart") Cart cart){
        item.setQuantity(item.getQuantity() + quantity);
        cart.addToCart(item);
        model.addAttribute("item", item);
        model.addAttribute("message", "Successfully added !");
        return "detail";
    }

    @GetMapping("/cart")
    public String getCartPage(@ModelAttribute("cart") Cart cart, Model model){
        List<Item> cart_item = cart.getCart();
        model.addAttribute("cart_item", cart_item);

        return "cart";
    }
}
