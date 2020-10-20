package com.example.arj.DAO;

import com.example.arj.Models.Employee;
import com.example.arj.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao implements Dao<Employee> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee find(Integer id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findByIsValidIsTrue() {
        return employeeRepository.findByIsValidIsTrue();
    }

    public void delete(Employee employeeD) {
        Employee employee= employeeRepository.getOne(employeeD.getId());
        employee.setValid(false);
        employeeRepository.save(employee);
    }

    public void delete(Integer id) {
        Employee employee= employeeRepository.getOne(id);
        employee.setValid(false);
        employeeRepository.save(employee);
    }
}
