package com.management.service;

import com.management.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void deleteById(Integer id);

    void save(Customer customer);
}
