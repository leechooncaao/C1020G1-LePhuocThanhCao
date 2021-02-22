package com.example.service.impl;

import com.example.service.ConvertCurrencyService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertCurrencyService {
    @Override
    public float convert(float usd, float rate) {
        return usd * rate;
    }
}
