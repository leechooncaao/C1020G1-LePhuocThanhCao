package com.cart_items.service.impl;

import com.cart_items.model.Item;
import com.cart_items.repository.ItemRepository;
import com.cart_items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getListItem() {
        return itemRepository.getListItem();
    }

    @Override
    public Item findItemById(int id) {
        return itemRepository.findItemById(id);
    }
}
