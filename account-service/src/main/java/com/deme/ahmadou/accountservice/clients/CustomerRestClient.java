package com.deme.ahmadou.accountservice.clients;

import com.deme.ahmadou.accountservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE/api/v1")
public interface CustomerRestClient {
    @GetMapping("/customers")
    List<Customer> getAllCustomers();

    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
}
