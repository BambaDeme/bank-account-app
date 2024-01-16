package com.deme.ahmadou.accountservice.controllers;

import com.deme.ahmadou.accountservice.clients.CustomerRestClient;
import com.deme.ahmadou.accountservice.entities.Account;
import com.deme.ahmadou.accountservice.models.Customer;
import com.deme.ahmadou.accountservice.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable String id){

        Account account = accountRepository.findById(id).get();

        Customer customer = customerRestClient.getCustomerById(account.getCustomerId());

        account.setCustomer(customer);

        return account;
    }
}
