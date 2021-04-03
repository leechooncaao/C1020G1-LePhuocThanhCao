package com.furama_server.controller;

import com.furama_server.model.customer.Customer;
import com.furama_server.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getListCustomers(){
        List<Customer> customerList =customerService.findAll();

        if(customerList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.save(customer);

        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer){
        Customer customerData = customerService.findById(id);

        if(customerData == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Integer id){
        Customer customerData = customerService.findById(id);

        if(customerData == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(customerData, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteById(@PathVariable("id") Integer id){
        Customer customerData = customerService.findById(id);

        if(customerData == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        customerService.delete(id);

        return new ResponseEntity<>(customerData, HttpStatus.OK);

    }


}
