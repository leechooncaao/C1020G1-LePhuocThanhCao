package com.furama_app.controller;

import com.furama_app.model.employee.AppUser;
import com.furama_app.model.employee.Employee;
import com.furama_app.service.employee.EmployeeService;
import com.furama_app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getListCustomerPage(Model model){
        model.addAttribute("listEmployee",employeeService.findAll());

        return "/employee/list";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("employee",new Employee());

        return "/employee/create";
    }

    @PostMapping("/save")
    public String create(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            return "/employee/create";
        }

        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Successfully created !");

        return "redirect:/employee/create";

    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "/employee/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "/employee/edit";
        }

        employeeService.save(employee);
        model.addAttribute("message", "Successfully updated !");

        return "/employee/edit";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer id){
        employeeService.delete(employeeService.findById(id));

        return "redirect:/employee/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search-data") String input, Model model){
        List<Employee> employees =  employeeService.findAllByNameContaining(input);

        if(employees.isEmpty())
            return "notFound";
        else {
            model.addAttribute("listEmployee", employees);
            return "/employee/list";
        }

    }
}
