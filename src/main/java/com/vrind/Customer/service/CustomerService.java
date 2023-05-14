package com.vrind.Customer.service;

import com.vrind.Customer.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int theId);

    Customer save(Customer customer);

    void deleteById(int theId);
}
