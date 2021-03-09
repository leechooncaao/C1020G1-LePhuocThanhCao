package com.cart_items.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item,Integer> cart;

    public Cart(){
        cart = new HashMap<>();
    }

    public void addToCart(Item item){
        if(cart.containsKey(item)){
            cart.replace(item,cart.get(item), cart.get(item) +1);
        }else {
            cart.put(item, 1);
        }
    }

    public void removeItem(Item item){
        cart.remove(item);
    }

    public int getQuantity(Item item){
        return cart.get(item);
    }

    public Map<Item, Integer> getCart(){
        return cart;
    }


}
