package com.deme.ahmadou.customerservice.repositories;

import com.deme.ahmadou.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
