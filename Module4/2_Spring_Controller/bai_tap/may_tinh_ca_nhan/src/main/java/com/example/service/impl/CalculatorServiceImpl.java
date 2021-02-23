package com.example.service.impl;

import com.example.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public float addition(float number1, float number2) {
        return number1 + number2;
    }

    @Override
    public float subtraction(float number1, float number2) {
        return number1 - number2;
    }

    @Override
    public float division(float number1, float number2) {
        return number1 / number2;
    }

    @Override
    public float multiplication(float number1, float number2) {
        return number1 * number2;
    }
}
