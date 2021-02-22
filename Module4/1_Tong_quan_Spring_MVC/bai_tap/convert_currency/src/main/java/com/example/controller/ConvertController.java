package com.example.controller;

import com.example.service.ConvertCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private ConvertCurrencyService convertCurrencyService;

    @GetMapping({"", "/convert"})
    public String convert(@RequestParam(value = "rate") String rate,
                          @RequestParam(value = "usd") String usd,
                          Model model){
        float result = convertCurrencyService.convert(Float.parseFloat(usd),Float.parseFloat(rate));
        model.addAttribute("result", result);

        return "/result";
    }
}

