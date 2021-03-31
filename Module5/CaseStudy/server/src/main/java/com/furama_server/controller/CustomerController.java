package com.furama_server.controller;

import com.furama_server.model.customer.Customer;
import com.furama_server.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @Autowired
//    private ContractService contractService;
    @GetMapping("")
    public ResponseEntity<List<Customer>> getListCustomers(){
        List<Customer> customerList =customerService.findAll();

        if(customerList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }


//    public String getListCustomerPage(Model model){
//        model.addAttribute("listCustomer",customerService.findAll());
//
//        return "/customer/list";
//    }

//    @GetMapping("/create")
//    public String getCreatePage(Model model){
//        model.addAttribute("customer",new Customer());
//
//        return "/customer/create";
//    }
//
//    @PostMapping("/save")
//    public String createCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        if (bindingResult.hasFieldErrors()) {
//            return "/customer/create";
//        }
//
//        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("message", "Successfully created !");
//
//        return "redirect:/customer/create";
//
//    }
//
//    @GetMapping("/edit/{id}")
//    public String getEditPage(@PathVariable("id") Integer id, Model model){
//        Customer customer = customerService.findById(id);
//
//        model.addAttribute("customer", customer);
//
//        return "/customer/edit";
//    }
//
//    @PostMapping("/update")
//    public String updateCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
//        if (bindingResult.hasFieldErrors()) {
//            return "/customer/edit";
//        }
//
//        customerService.save(customer);
//        model.addAttribute("message", "Successfully updated !");
//
//        return "/customer/edit";
//    }
//
//    @GetMapping("/delete")
//    public String deleteCustomer(@RequestParam("id") Integer id){
//        customerService.delete(customerService.findById(id));
//
//        return "redirect:/customer/list";
//    }
//
//    @GetMapping("/search")
//    public String search(@RequestParam("search-data") String input, Model model){
//        List<Customer> customers =  customerService.findAllByNameContaining(input);
//
//        if(customers.isEmpty())
//            return "notFound";
//        else {
//            model.addAttribute("listCustomer", customers);
//            return "/customer/list";
//        }
//
//    }
//
//    @GetMapping("/active")
//    public String getListActiveCustomer(Model model){
//        List<Contract> contracts = contractService.findAllByStartDateBeforeAndEndDateAfter(LocalDate.now().toString());
//
//        model.addAttribute("contracts", contracts);
//
//        return "/customer/active-customer";
//    }
//
//    @GetMapping("/search-active")
//    public String searchActiveCustomer(Model model, @RequestParam("search-data") String input){
//        List<Contract> contracts = contractService.findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(LocalDate.now().toString(), input);
//
//        model.addAttribute("contracts", contracts);
//
//        return "/customer/active-customer";
//    }


}
