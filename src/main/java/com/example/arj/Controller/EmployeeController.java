package com.example.arj.Controller;

import com.example.arj.DAO.EmployeeDao;
import com.example.arj.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employee/")
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("find/{id}")
    public Employee find(@PathVariable("id") Integer id) {
        return employeeDao.find(id);
    }

    @GetMapping("findAll")
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @PostMapping("save")
    public Employee save(@Valid @RequestBody Employee employee) {
        return employeeDao.save(employee);
    }

    @PostMapping("update")
    public Employee update(@Valid @RequestBody Employee employee) {
        return employeeDao.save(employee);
    }

    @DeleteMapping("delete")
    public void delete(@Valid @RequestBody Employee employee) {
        employeeDao.delete(employee);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
    }
}
