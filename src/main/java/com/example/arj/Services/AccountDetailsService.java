package com.example.arj.Services;

import com.example.arj.DAO.AccountDao;
import com.example.arj.Models.Account;
import com.example.arj.Models.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class AccountDetailsService implements UserDetailsService {
    /*
        Overriding user comparison methods for username and password by using users from our database.
    */
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountDao.findByUsername(username);

        System.out.println("In AccountDetailsService: "+username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        //Creating user of type compatible with boot-security auths
        return new CustomUser(account.getUsername(), bCryptPasswordEncoder.encode(account.getPassword()), Collections.emptyList(),account.getEmployee(),account.getEmployee().getPosition());
//        return new User(account.getUsername(), bCryptPasswordEncoder.encode(account.getPassword()), Collections.emptyList());
    }
}
