package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepos {
    List<Product> findAll();

    void create(Product product);

    void updateById(Integer id, Product product);

    void deleteById(Integer id);

    Product showDetailInfo(Integer id);

    Product findById(Integer id);
}
