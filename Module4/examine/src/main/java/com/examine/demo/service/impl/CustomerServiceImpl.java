package com.examine.demo.service.impl;

import com.examine.demo.entity.Customer;
import com.examine.demo.repository.CustomerRespository;
import com.examine.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRespository customerRespository;

    @Override
    public List<Customer> findAll() {
        return customerRespository.findAll();
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public List<Customer> findAllByNameContaining(String name) {
        return customerRespository.findAllByNameContaining(name);
    }
}
