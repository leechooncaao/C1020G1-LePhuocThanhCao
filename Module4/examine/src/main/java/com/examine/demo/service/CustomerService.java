package com.examine.demo.service;


import com.examine.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Customer customer);

    List<Customer> findAllByNameContaining(String name);


}
