package com.furama_app.service.service_app;

import com.furama_app.model.customer.Customer;
import com.furama_app.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServServiceImpl implements ServService{
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public List<com.furama_app.model.service.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(com.furama_app.model.service.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public com.furama_app.model.service.Service findById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<com.furama_app.model.service.Service> findAllByNameContaining(String name) {
        return serviceRepository.findAllByNameContaining(name);
    }

    @Override
    public void delete(com.furama_app.model.service.Service service) {
        serviceRepository.delete(service);
    }


}
