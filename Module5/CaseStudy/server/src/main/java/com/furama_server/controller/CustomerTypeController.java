package com.furama_server.controller;


import com.furama_server.model.customer.CustomerType;
import com.furama_server.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer_type")
public class CustomerTypeController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("")
    public ResponseEntity<List<CustomerType>> getAll(){
        List<CustomerType> customerTypeList = customerTypeService.findAll();

        if(customerTypeList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(customerTypeList, HttpStatus.OK);
    }
}
