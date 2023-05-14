package com.vrind.Customer.service;

import com.vrind.Customer.dao.CustomerDAO;
import com.vrind.Customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional
    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Transactional
    @Override
    public Customer findById(int id) {
        return customerDAO.findById(id);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        customerDAO.deleteById(id);
    }
}






