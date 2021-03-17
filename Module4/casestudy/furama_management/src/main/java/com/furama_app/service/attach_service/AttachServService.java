package com.furama_app.service.attach_service;

import com.furama_app.model.contract.AttachService;

import java.util.List;

public interface AttachServService {
    AttachService findById(Integer id);

    List<AttachService> findAll();

    AttachService findByName(String name);

}
