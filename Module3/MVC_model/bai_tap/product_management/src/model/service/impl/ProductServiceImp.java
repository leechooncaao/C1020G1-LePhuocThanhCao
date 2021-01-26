package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepos;
import model.repository.impl.ProductReposImp;
import model.service.ProductService;

import java.util.List;

public class ProductServiceImp implements ProductService {

    private ProductRepos productRepos = new ProductReposImp();

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
}
