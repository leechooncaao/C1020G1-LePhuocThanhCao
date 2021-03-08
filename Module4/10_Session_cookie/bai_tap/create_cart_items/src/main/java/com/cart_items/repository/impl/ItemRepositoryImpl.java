package com.cart_items.repository.impl;

import com.cart_items.model.Item;
import com.cart_items.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private static List<Item> itemList = new ArrayList<>();

    static {
        itemList.add(new Item(1, "Iphone X", 2000.0, 0));
        itemList.add(new Item(2, "Sony Z3", 1000.0, 0));
        itemList.add(new Item(3, "Samsung S8", 1500.0, 0));
    }

    @Override
    public List<Item> getListItem() {
        return itemList;
    }

    @Override
    public Item findItemById(int id) {
        for (Item item : itemList){
            if(item.getId() == id)
                return item;
        }

        return null;
    }
}
