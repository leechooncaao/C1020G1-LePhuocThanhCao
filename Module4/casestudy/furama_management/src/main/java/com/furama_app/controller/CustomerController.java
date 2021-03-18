package com.furama_app.controller;

import com.furama_app.model.contract.Contract;
import com.furama_app.model.customer.Customer;
import com.furama_app.service.contract.ContractService;
import com.furama_app.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/list")
    public String getListCustomerPage(Model model){
        model.addAttribute("listCustomer",customerService.findAll());

        return "/customer/list";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("customer",new Customer());

        return "/customer/create";
    }

    @PostMapping("/save")
    public String createCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            return "/customer/create";
        }

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Successfully created !");

        return "redirect:/customer/create";

    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id, Model model){
        Customer customer = customerService.findById(id);

        model.addAttribute("customer", customer);

        return "/customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "/customer/edit";
        }

        customerService.save(customer);
        model.addAttribute("message", "Successfully updated !");

        return "/customer/edit";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer id){
        customerService.delete(customerService.findById(id));

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search-data") String input, Model model){
        List<Customer> customers =  customerService.findAllByNameContaining(input);

        if(customers.isEmpty())
            return "notFound";
        else {
            model.addAttribute("listCustomer", customers);
            return "/customer/list";
        }

    }

    @GetMapping("/active")
    public String getListActiveCustomer(Model model){
        List<Contract> contracts = contractService.findAllByStartDateBeforeAndEndDateAfter(LocalDate.now().toString());

        model.addAttribute("contracts", contracts);

        return "/customer/active-customer";
    }

    @GetMapping("/search-active")
    public String searchActiveCustomer(Model model, @RequestParam("search-data") String input){
        List<Contract> contracts = contractService.findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(LocalDate.now().toString(), input);

        model.addAttribute("contracts", contracts);

        return "/customer/active-customer";
    }


}
