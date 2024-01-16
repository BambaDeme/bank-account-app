package com.deme.ahmadou.accountservice;

import com.deme.ahmadou.accountservice.clients.CustomerRestClient;
import com.deme.ahmadou.accountservice.entities.Account;
import com.deme.ahmadou.accountservice.enums.AccountType;
import com.deme.ahmadou.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient){

        return args -> {
            customerRestClient.getAllCustomers().forEach(customer -> {

                List<Account> accountList = List.of(
                        Account.builder()
                                .accountId(UUID.randomUUID().toString())
                                .balance(Math.random()*200_000)
                                .currency("XOF")
                                .type(AccountType.CURRENT_ACCOUNT)
                                .customerId(customer.getId())
                                .createdAt(LocalDate.now())
                                .build(),
                        Account.builder()
                                .accountId(UUID.randomUUID().toString())
                                .balance(Math.random()*300_430)
                                .currency("XOF")
                                .type(AccountType.SAVING_ACCOUNT)
                                .customerId(customer.getId())
                                .createdAt(LocalDate.now())
                                .build()
                );
                accountRepository.saveAll(accountList);
            });

        };
    }

}
