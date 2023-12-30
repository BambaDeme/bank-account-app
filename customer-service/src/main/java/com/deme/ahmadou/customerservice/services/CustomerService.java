package com.deme.ahmadou.customerservice.services;

import com.deme.ahmadou.customerservice.entities.Customer;
import com.deme.ahmadou.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
    }
}
