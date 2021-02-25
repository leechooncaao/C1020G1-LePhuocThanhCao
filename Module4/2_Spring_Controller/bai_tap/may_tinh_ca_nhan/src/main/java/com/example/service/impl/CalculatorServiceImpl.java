package com.example.service.impl;

import com.example.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private float addition(float number1, float number2) {
        return number1 + number2;
    }

    private float subtraction(float number1, float number2) {
        return number1 - number2;
    }

    private float division(float number1, float number2) {
        return number1 / number2;
    }

    private float multiplication(float number1, float number2) {
        return number1 * number2;
    }

    @Override
    public String calculate(float number1, float number2, String operator){
        String result;

        switch (operator){
            case "+" :
                result = "Addition: " + addition(number1, number2);
                break;
            case "-" :
                result = "Subtraction: " + subtraction(number1, number2);
                break;
            case "/" :
                if(number2 != 0){
                    result = "Division: " + division(number1, number2);
                }else {
                    result = "Division: Error";
                }
                break;
            case "*" :
                result = "Multiplication: " + multiplication(number1, number2);
                break;
            default:
                result = "Error";
        }

        result = "Result " + result;

        return result;
    }
}
