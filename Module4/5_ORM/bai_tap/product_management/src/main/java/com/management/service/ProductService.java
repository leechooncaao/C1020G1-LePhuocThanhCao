package com.management.service;

import com.management.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void create(Product product);

    void updateById(Integer id, Product product);

    void deleteById(Integer id);

    Product showDetailInfo(Integer id);

    Product findById(Integer id);

    int getIdProduct();
}
