package com.example.arj.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    public CustomUser(String username, String password,
         Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    private Employee employee;
}
