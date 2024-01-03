package com.deme.ahmadou.accountservice;

import com.deme.ahmadou.accountservice.entities.Account;
import com.deme.ahmadou.accountservice.enums.AccountType;
import com.deme.ahmadou.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {
            List<Account> accountList = List.of(
                    Account.builder()
                            .accountId(UUID.randomUUID().toString())
                            .balance(200_000)
                            .currency("XOF")
                            .type(AccountType.CURRENT_ACCOUNT)
                            .customerId(1L)
                            .createdAt(LocalDate.now())
                            .build(),
                    Account.builder()
                            .accountId(UUID.randomUUID().toString())
                            .balance(300_000)
                            .currency("XOF")
                            .type(AccountType.CURRENT_ACCOUNT)
                            .customerId(2L)
                            .createdAt(LocalDate.now())
                            .build(),
                    Account.builder()
                            .accountId(UUID.randomUUID().toString())
                            .balance(500_000)
                            .currency("XOF")
                            .type(AccountType.SAVING_ACCOUNT)
                            .customerId(3L)
                            .createdAt(LocalDate.now())
                            .build()
            );

            accountRepository.saveAll(accountList);
        };
    }

}
