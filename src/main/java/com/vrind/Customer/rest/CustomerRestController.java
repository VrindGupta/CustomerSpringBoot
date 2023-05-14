package com.vrind.Customer.rest;

import com.vrind.Customer.entity.Customer;
import com.vrind.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService){this.customerService = customerService;}
    @GetMapping("/customers")
    public List<Customer> getStudents() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer theCustomer = customerService.findById(customerId);

        if (theCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        return theCustomer;
    }
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        customer.setId(0);

        Customer dbCustomer = customerService.save(customer);

        return dbCustomer;
    }
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        Customer dbCustomer = customerService.save(customer);

        return dbCustomer;
    }
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer tempCustomer = customerService.findById(customerId);

        // throw exception if null

        if (tempCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        customerService.deleteById(customerId);

        return "Deleted customer id - " + customerId;
    }
}