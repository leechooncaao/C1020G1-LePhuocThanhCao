package com.management.repository.repos_impl;

import com.management.model.Product;
import com.management.repository.ProductRepos;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductReposImpl implements ProductRepos {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1,"Realme 7i",1000,"nothing", "Xiaomi"));
        productMap.put(2, new Product(2,"Iphone Pro X",2000,"nothing", "Apple"));
        productMap.put(3, new Product(3,"Iphone 11",1500,"nothing", "Apple"));
        productMap.put(4, new Product(4,"Samsung S11",1800,"nothing", "Samsung"));
        productMap.put(5, new Product(5,"Sony XZ 3",1200,"nothing", "Sony"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void updateById(Integer id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void deleteById(Integer id) {
        productMap.remove(id);
    }

    @Override
    public Product showDetailInfo(Integer id) {
        return productMap.get(id);
    }

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public int getIdProduct() {
        return 0;
    }
}
