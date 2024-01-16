package com.deme.ahmadou.accountservice.clients;

import com.deme.ahmadou.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE/api/v1")
public interface CustomerRestClient {
    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomersDefault")
    List<Customer> getAllCustomers();

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);

    default Customer getDefaultCustomer(Long id, Exception exception){
        return Customer.builder()
                .id(id)
                .firstName("Not available")
                .lastName("Not available")
                .email("Not available")
                .build();
    }

    default List<Customer> getAllCustomersDefault(Exception exception) {
        return List.of();
    }
}
