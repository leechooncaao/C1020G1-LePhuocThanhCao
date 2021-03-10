package com.csm_i18n.service.impl;

import com.csm_i18n.model.Customer;
import com.csm_i18n.repository.CustomerRepository;
import com.csm_i18n.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
