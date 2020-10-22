package com.example.arj.Controller;

import com.example.arj.DAO.MakeDao;
import com.example.arj.Models.Make;
import com.example.arj.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/make")
public class MakeController {
    @Autowired
    MakeDao makeDao;

    @Autowired
    AdminService adminService;

    //http://localhost:8010/make/find/1
    @GetMapping("/{id}")
    public Make find(@PathVariable("id") Integer id) {
        return makeDao.find(id);
    }



    //http://localhost:8010/make/findAll
    @GetMapping
    public List<Make> findAll() {
        return adminService.findAllValidMakes();
    }


    /*
    http://localhost:8010/make/save
    body:
    {
	    "value":"5"
	}
     */
    @PostMapping
    public Make save(@Valid @RequestBody Make make) {
        return makeDao.save(make);
    }



    /*
    http://localhost:8010/make/update
    body:
    {
        "id":"8",
        "value":"5"
    }
     */
    @PostMapping("/update")
    public Make update(@Valid @RequestBody Make make) {
        return makeDao.save(make);
    }



    /*
    http://localhost:8010/make/delete
    body:
    {
        "id": "7"
    }
     */
    @DeleteMapping
    public void delete(@Valid @RequestBody Make make) {
        makeDao.delete(make);
    }



    //http://localhost:8010/make/delete/5
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        makeDao.delete(id);
    }
}
