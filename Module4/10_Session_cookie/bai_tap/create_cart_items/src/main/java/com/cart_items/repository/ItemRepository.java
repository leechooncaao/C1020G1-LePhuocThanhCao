package com.cart_items.repository;

import com.cart_items.model.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> getListItem();

    Item findItemById(int id);
}
