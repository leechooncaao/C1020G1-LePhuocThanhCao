package com.furama_server.service.customer;


import com.furama_server.model.customer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Customer customer);

    List<Customer> findAllByNameContaining(String name);
}
