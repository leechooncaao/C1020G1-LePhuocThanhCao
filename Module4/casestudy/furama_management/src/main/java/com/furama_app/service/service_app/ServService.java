package com.furama_app.service.service_app;

import com.furama_app.model.customer.Customer;
import com.furama_app.model.service.Service;

import java.util.List;

public interface ServService {
    List<Service> findAll();

    void save(Service service);

    Service findById(Integer id);

    List<Service> findAllByNameContaining(String name);

    void delete(Service service);
}
