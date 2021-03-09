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
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void remove(Integer id) {
        itemRepository.deleteById(id);
    }
}
