package com.furama_server.service.customer;

import com.furama_server.model.customer.Customer;
import com.furama_server.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }


    @Override
    public List<Customer> findAllByNameContaining(String name) {
        return customerRepository.findAllByNameContaining(name);
    }
}