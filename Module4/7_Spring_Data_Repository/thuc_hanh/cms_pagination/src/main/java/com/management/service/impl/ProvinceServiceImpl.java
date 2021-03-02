package com.management.service.impl;

import com.management.model.Province;
import com.management.repository.ProvinceRepository;
import com.management.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Integer id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }
}
