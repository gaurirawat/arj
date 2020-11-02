package com.example.arj.Repositories;

import com.example.arj.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    public  Account findByUsername(String username);
}
