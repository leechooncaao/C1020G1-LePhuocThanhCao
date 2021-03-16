package com.furama_app.service.attach_service;

import com.furama_app.model.contract.AttachService;
import com.furama_app.repository.AttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachServiceImpl implements AttachServService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;


    @Override
    public AttachService findById(Integer id) {
        return attachServiceRepository.findById(id).orElse(null);
    }
}
