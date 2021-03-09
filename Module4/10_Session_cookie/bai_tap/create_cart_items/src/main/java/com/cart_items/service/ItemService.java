package com.cart_items.service;

import com.cart_items.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findById(Integer id);

    void save(Item item);

    void remove(Integer id);
}
