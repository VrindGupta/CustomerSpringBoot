package com.vrind.Customer.dao;

import java.util.List;

import com.vrind.Customer.entity.Customer;

public interface CustomerDAO {

	List<Customer> findAll();

	Customer save(Customer customer);

	Customer findById(int id);

	void deleteById(int id);
	
}
