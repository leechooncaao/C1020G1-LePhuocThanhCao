package com.management.controller;

import com.management.model.Customer;
import com.management.model.Province;
import com.management.service.CustomerService;
import com.management.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/customers")
    public String showListCustomer(Model model){
        Iterable<Customer> customerList = customerService.findAll();
        model.addAttribute("listCustomer",customerList );

        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/customer/save")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Successfully created !");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/customer/update")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Successfully updated !");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/customer/delete")
    public String delete(@ModelAttribute Customer customer, RedirectAttributes redirect) {
        customerService.deleteById(customer.getId());
        redirect.addFlashAttribute("message", "Successfully removed !");
        return "redirect:/";
    }
}
