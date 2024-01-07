package com.deme.ahmadou.customerservice.services;

import com.deme.ahmadou.customerservice.entities.Customer;
import com.deme.ahmadou.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
    }
}
