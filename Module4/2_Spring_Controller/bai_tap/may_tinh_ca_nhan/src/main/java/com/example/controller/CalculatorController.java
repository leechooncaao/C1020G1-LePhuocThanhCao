package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String getHome(){
        return "/index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam float number1, @RequestParam float number2,
                            Model model, @RequestParam String operator){
        String result = calculatorService.calculate(number1, number2, operator);
        model.addAttribute("result", result);

        return "/index";
    }
}
