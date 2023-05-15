package com.vrind.Customer.service;

import com.vrind.Customer.dao.CustomerRepository;
import com.vrind.Customer.dto.CustomerDTO;
import com.vrind.Customer.entity.Customer;
import com.vrind.Customer.rest.CustomerNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(int id) {
        Optional<Customer> result = customerRepository.findById(id);
        Customer customer = null;
        if(result.isPresent()){
            customer = result.get();
        }
        else{
            throw new CustomerNotFoundException("Customer was not found");
        }
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO save(CustomerDTO theCustomerDTO) {
        Customer customer = modelMapper.map(theCustomerDTO, Customer.class);
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}






