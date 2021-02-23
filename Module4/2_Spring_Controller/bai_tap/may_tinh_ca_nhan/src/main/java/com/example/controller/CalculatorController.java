package com.example.controller;

import com.example.service.CalculatorService;
import com.example.service.impl.CalculatorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    CalculatorService calculatorService = new CalculatorServiceImpl();

    @GetMapping("/")
    public String getHome(){
        return "/index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam float number1, @RequestParam float number2,
                            Model model, @RequestParam String operator){
        String result;

        switch (operator){
            case "+" :
                result = "Addition: " + calculatorService.addition(number1, number2);
                break;
            case "-" :
                result = "Subtraction: " + calculatorService.subtraction(number1, number2);
                break;
            case "/" :
                if(number2 != 0){
                    result = "Division: " + calculatorService.division(number1, number2);
                }else {
                    result = "Division: Error";
                }
                break;
            case "*" :
                result = "Multiplication: " + calculatorService.multiplication(number1, number2);
                break;
            default:
                result = "Error";
        }

        result = "Result " + result;

        model.addAttribute("result", result);

        return "/index";

    }
}
