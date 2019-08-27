package com.randi.ordermanagereventuatelocal.controller;

import com.randi.ordermanagereventuatelocal.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value="/customer")
    public String getCustomer(){
        return "Yeay!!";
    }

   @PostMapping(value = "/customer/create")
    public String createCustomer( @RequestBody CreateCustomerRequest body){
        log.info("Customer create request is called [{}]",body);
        return customerService.createCustomer(body.getNic(),body.getFirstName(),body.getLastName());
    }
}
