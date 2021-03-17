package com.furama_app.service.attach_service;

import com.furama_app.model.contract.AttachService;
import com.furama_app.repository.AttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;


    @Override
    public AttachService findById(Integer id) {
        return attachServiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService findByName(String name) {
        return attachServiceRepository.findByName(name);
    }
}
