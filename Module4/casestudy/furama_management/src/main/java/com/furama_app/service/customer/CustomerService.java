package com.furama_app.service.customer;

import com.furama_app.model.customer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Customer customer);

    List<Customer> findAllByNameContaining(String name);
}
