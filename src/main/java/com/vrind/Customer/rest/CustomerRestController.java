package com.vrind.Customer.rest;

import com.vrind.Customer.dto.CustomerDTO;
import com.vrind.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService){this.customerService = customerService;}
    @GetMapping("/")
    public List<CustomerDTO> getAllCustomers() {

        return customerService.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable int customerId) {

        return ResponseEntity.ok().body(customerService.findById(customerId));
    }
    @PostMapping("/")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {

        customerDTO.setId(0);
        return ResponseEntity.ok().body(customerService.save(customerDTO));
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {

        return ResponseEntity.ok().body(customerService.save(customerDTO));
    }
    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable int customerId) {

        return ResponseEntity.ok().body(null);
    }
}