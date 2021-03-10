package com.phone_management.service;

import com.phone_management.model.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();

    Smartphone findById(Integer id);

    Smartphone save(Smartphone phone);

    Smartphone remove(Integer id);
}
