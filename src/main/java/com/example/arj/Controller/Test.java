package com.example.arj.Controller;

import com.example.arj.DAO.EmployeeDao;
import com.example.arj.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("test")
public class Test {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/get")
    public Employee test(@RequestParam Integer id){
        return employeeDao.find(id);
    }
}
