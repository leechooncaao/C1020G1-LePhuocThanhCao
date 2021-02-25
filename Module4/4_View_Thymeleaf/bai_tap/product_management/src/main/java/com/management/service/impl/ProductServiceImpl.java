package com.management.service.impl;

import com.management.model.Product;
import com.management.repository.ProductRepos;
import com.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepos productRepos;

    @Override
    public List<Product> findAll() {
        return productRepos.findAll();
    }

    @Override
    public void create(Product product) {
        productRepos.create(product);
    }

    @Override
    public void updateById(Integer id, Product product) {
        productRepos.updateById(id, product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepos.deleteById(id);
    }

    @Override
    public Product showDetailInfo(Integer id) {
        return productRepos.showDetailInfo(id);
    }

    @Override
    public Product findById(Integer id) {
        return productRepos.findById(id);
    }

    @Override
    public int getIdProduct() {
        return findAll().size() + 1;
    }
}
