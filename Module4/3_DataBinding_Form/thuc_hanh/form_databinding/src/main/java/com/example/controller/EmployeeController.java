package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @GetMapping("/")
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "/create";
    }

    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "/info";
    }
}
