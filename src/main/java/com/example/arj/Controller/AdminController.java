package com.example.arj.Controller;


import com.example.arj.Models.*;
import com.example.arj.Services.AdminService;
import com.example.arj.Utils.Wrappers.AdminWrapper;
import com.example.arj.Utils.Wrappers.UpdateWrapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/position")
    public List<Position> findAllPositions() {
        return adminService.findAllValidPositions();
    }

    @PostMapping("/updatePosition")
    public void updatePositions(@Valid @RequestBody UpdateWrapper<Position> updateWrapper){
//        List<Position> addPositions=updateWrapper.getAddList();
//        List<Position> deletePositions=updateWrapper.getDeleteList();
        adminService.updatePositions(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }

    @GetMapping("/make")
    public List<Make> findAllMakes() {
        return adminService.findAllValidMakes();
    }

    /*
    http://localhost:8010/admin/updateMake
    request body:
        {
            "addList":
            [
                {"value":"gram"},
                {"value":"kilogram"},
                {"value":"milligram"}
            ],
            "deleteList":
            [
                {"id":"1"},
                {"id":"2","value":"2"}
            ]
        }
    */
    @PostMapping("/updateMake")
    public void updateMakes(@Valid @RequestBody UpdateWrapper<Make> updateWrapper){
        adminService.updateMakes(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }

    @GetMapping("/origin")
    public List<Origin> findAllOrigins() {
        return adminService.findAllValidOrigins();
    }

    @PostMapping("/updateOrigin")
    public void updateOrigins(@Valid @RequestBody UpdateWrapper<Origin> updateWrapper){
        adminService.updateOrigins(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }

    @GetMapping("/uom")
    public List<UOM> findAllUOMs() {
        return adminService.findAllValidUOMs();
    }

    @PostMapping("/updateUOM")
    public void updateUOMs(@Valid @RequestBody UpdateWrapper<UOM> updateWrapper){
        adminService.updateUOMs(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }

    @GetMapping("/item")
    public List<Item> findAllItems() {
        return adminService.findAllValidItems();
    }

    @GetMapping("/itemByServiceId")
    public List<Item> findAllItemsByServiceId(@RequestParam Integer id){return adminService.findAllValidItemsByServiceId(id);}

    @PostMapping("/updateItem")
    public void updateItems(@Valid @RequestBody UpdateWrapper<Item> updateWrapper){
        adminService.updateItems(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }

    @GetMapping("/service")
    public List<Service> findAllServices() {
        return adminService.findAllValidServices();
    }

    @PostMapping("/updateService")
    public void updateServices(@Valid @RequestBody UpdateWrapper<Service> updateWrapper){
        adminService.updateServices(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }


    /*
    Request Body:
       {
            "name": "smit",
            "username":"drogo",
            "password": "drogo",
            "positionId": "1"
       }
     */
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@Valid @RequestBody AdminWrapper adminWrapper){
        String name=adminWrapper.getName();
        String username=adminWrapper.getUsername();
        String password=adminWrapper.getPassword();
        int positionId=adminWrapper.getPositionId();
        return adminService.saveEmployee(name, username, password, positionId);
    }

    /*
    Request Body:
    {
        "name": "project3",
        "code":"p3",
        "managerId": "2",
        "peIds": [1,3]
    }
     */
    @PostMapping("/createProject")
    public Project createProject(@Valid @RequestBody AdminWrapper adminWrapper){
        String name=adminWrapper.getName();
        String code=adminWrapper.getCode();
        int managerId=adminWrapper.getManagerId();
        List<Integer> peIds=adminWrapper.getPeIds();
        return adminService.createProject(name, code, managerId, peIds);
    }
}
