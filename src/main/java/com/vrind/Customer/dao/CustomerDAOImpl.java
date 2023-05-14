package com.vrind.Customer.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vrind.Customer.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private EntityManager entityManager;

	@Autowired
	public CustomerDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	@Override
	public List<Customer> findAll() {

		// create a query
		TypedQuery<Customer> theQuery = entityManager.createQuery("from Customer", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public Customer save(Customer theCustomer) {
		Customer dbCustomer = entityManager.merge(theCustomer);
		return dbCustomer;
	}

	@Override
	public Customer findById(int theId) {

		// get customer
		Customer customer = entityManager.find(Customer.class, theId);

		// return customer
		return customer;
	}


	@Override
	public void deleteById(int theId) {

		// find customer by id
		Customer customer = entityManager.find(Customer.class, theId);

		// remove customer
		entityManager.remove(customer);
	}

}
