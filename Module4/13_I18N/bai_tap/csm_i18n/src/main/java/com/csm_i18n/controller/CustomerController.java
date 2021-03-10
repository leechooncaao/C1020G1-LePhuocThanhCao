package com.csm_i18n.controller;

import com.csm_i18n.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String getListCustomer(Model model){
        model.addAttribute("customers",customerService.findAll());

        return "list";
    }
}
