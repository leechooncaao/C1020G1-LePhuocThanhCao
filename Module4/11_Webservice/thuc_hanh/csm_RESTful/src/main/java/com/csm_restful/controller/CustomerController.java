package com.csm_restful.controller;

import com.csm_restful.model.Customer;
import com.csm_restful.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/")
    public ResponseEntity<List<Customer>> listAllCustomer(){
        List<Customer> customers = customerService.findAll();

        if(customers.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id ){
        Customer customer = customerService.findById(id);

        if(customer == null)
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PostMapping("/customers/")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder){
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        Customer currentCustomer = customerService.findById(id);

        if(currentCustomer == null)
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);

        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName());
        currentCustomer.setId(customer.getId());

        customerService.save(currentCustomer);

        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        Customer customer = customerService.findById(id);

        if(customer == null)
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);

        customerService.remove(id);

        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
}
