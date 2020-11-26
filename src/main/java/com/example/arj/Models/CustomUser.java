package com.example.arj.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    public CustomUser(String username, String password,
         Collection<? extends GrantedAuthority> authorities,Employee employee,Position position) {
        super(username, password, authorities);
        this.setEmployee(employee);
        this.setPosition(position);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private Employee employee;
    private Position position;  //because of lazy loading not able to reach position from employee.

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
