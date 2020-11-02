package com.example.arj.Controller;

import com.example.arj.DAO.AccountDao;
import com.example.arj.DAO.EmployeeDao;
import com.example.arj.Models.Account;
import com.example.arj.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController()
@RequestMapping("test")
public class Test {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    AccountDao accountDao;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Account account, HttpServletResponse response){
        Account user = accountDao.findByUsername(account.getUsername());
        if(user==null){
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
        if(account.getPassword()==null || !account.getPassword().equals(user.getPassword())){
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
        Cookie cookie = new Cookie("token", "token:"+user.getUsername());
        user.setToken("token:"+user.getUsername());
        accountDao.update(user);
        response.addCookie(cookie);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Employee> test(@RequestParam Integer id,@CookieValue(value = "token",defaultValue = "")String token){
        try {
            Employee emp = employeeDao.find(id);
            System.out.println(token);
            if(token==null || token=="" || emp.getAccount().getToken() ==null || emp.getAccount().getToken().equals("") || !emp.getAccount().getToken().equals(token)){
                return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
            }
            return new ResponseEntity<>(emp,HttpStatus.OK);
        }
        catch (EntityNotFoundException entityNotFoundException){
            //Employee with id `id` doesn't exist
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }

    }
}
