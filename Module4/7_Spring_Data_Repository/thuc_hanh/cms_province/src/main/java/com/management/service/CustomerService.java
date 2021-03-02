package com.management.service;

import com.management.model.Customer;
import com.management.model.Province;

import java.util.List;

public interface CustomerService extends Service<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
