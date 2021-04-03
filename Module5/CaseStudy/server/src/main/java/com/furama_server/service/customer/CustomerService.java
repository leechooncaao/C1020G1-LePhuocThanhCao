package com.furama_server.service.customer;


import com.furama_server.model.customer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer save(Customer customer);

    Customer findById(Integer id);

    void delete(Integer id);

    List<Customer> findAllByNameContaining(String name);
}
