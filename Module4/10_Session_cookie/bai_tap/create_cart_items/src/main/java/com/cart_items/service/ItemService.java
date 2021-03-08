package com.cart_items.service;

import com.cart_items.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getListItem();

    Item findItemById(int id);
}
