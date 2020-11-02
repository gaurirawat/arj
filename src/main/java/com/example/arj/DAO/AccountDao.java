package com.example.arj.DAO;

import com.example.arj.Models.Account;
import com.example.arj.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDao implements Dao<Account> {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account find(Integer id) {
        return accountRepository.getOne(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    public Account findByUsername(String username){
        return accountRepository.findByUsername(username);
    }
}
