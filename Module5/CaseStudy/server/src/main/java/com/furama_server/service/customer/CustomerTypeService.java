package com.furama_server.service.customer;

import com.furama_server.model.customer.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
}
