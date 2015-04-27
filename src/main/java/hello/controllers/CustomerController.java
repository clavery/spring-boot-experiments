/*
 * Copyright (c) 2015 Charles Lavery <charles.lavery@gmail.com>
 */

package hello.controllers;

import hello.Customer;
import hello.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customers")
    public Iterable<Customer> getCustomers()
    {
        return customerRepository.findAll();
    }
}
