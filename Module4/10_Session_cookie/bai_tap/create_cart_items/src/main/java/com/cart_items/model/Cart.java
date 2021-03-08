package com.cart_items.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<Integer,Item> map = new HashMap<>();

    public void addToCart(Item item){
        map.put(item.getId(), item);
    }

    public List<Item> getCart(){
        return new ArrayList<>(map.values());
    }
}
