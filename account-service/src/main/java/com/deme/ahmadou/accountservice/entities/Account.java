package com.deme.ahmadou.accountservice.entities;

import com.deme.ahmadou.accountservice.enums.AccountType;
import com.deme.ahmadou.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString @Builder
public class Account {
    @Id
    private String accountId;

    private double balance;

    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private LocalDate createdAt;

    private Long customerId;

    @Transient
    private Customer customer;
}
