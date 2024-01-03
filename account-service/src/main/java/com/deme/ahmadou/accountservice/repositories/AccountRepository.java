package com.deme.ahmadou.accountservice.repositories;

import com.deme.ahmadou.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
