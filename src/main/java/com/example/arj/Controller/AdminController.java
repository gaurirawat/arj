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

    @PostMapping("/position")
    public Position savePosition(@Valid @RequestBody UpdateWrapper<Position> updateWrapper) {
        return adminService.savePosition(updateWrapper.getSave());
    }

    @PostMapping("/updatePosition")
    public Position updatePosition(@Valid @RequestBody UpdateWrapper<Position> updateWrapper) {
        System.out.println(updateWrapper.getUpdate().toString());
        return adminService.updatePosition(updateWrapper.getUpdate());
    }

    @PostMapping("/deletePosition")
    public void deletePosition(@Valid @RequestBody UpdateWrapper<Position> updateWrapper) {
        adminService.deletePosition(updateWrapper.getDeleteId());
    }

    @GetMapping("/position")
    public List<Position> findAllPositions() {
        return adminService.findAllValidPositions();
    }

    @PostMapping("/updatePositions")
    public void updatePositions(@Valid @RequestBody UpdateWrapper<Position> updateWrapper){
//        List<Position> savePositions=updateWrapper.getSaveList();
//        List<Position> deletePositions=updateWrapper.getDeleteList();
        adminService.updatePositions(updateWrapper.getSaveList(), updateWrapper.getDeleteList());
    }






    @PostMapping("/make")
    public Make saveMake(@Valid @RequestBody UpdateWrapper<Make> updateWrapper) {
        return adminService.saveMake(updateWrapper.getSave());
    }

    @PostMapping("/updateMake")
    public Make updateMake(@Valid @RequestBody UpdateWrapper<Make> updateWrapper) {
        return adminService.updateMake(updateWrapper.getUpdate());
    }

    @PostMapping("/deleteMake")
    public void deleteMake(@Valid @RequestBody UpdateWrapper<Make> updateWrapper) {
        adminService.deleteMake(updateWrapper.getDeleteId());
    }

    @GetMapping("/make")
    public List<Make> findAllMakes() {
        return adminService.findAllValidMakes();
    }

    /*
    http://localhost:8010/admin/updateMake
    request body:
        {
            "saveList":
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
    @PostMapping("/updateMakes")
    public void updateMakes(@Valid @RequestBody UpdateWrapper<Make> updateWrapper){
        adminService.updateMakes(updateWrapper.getSaveList(), updateWrapper.getDeleteList());
    }







    @PostMapping("/origin")
    public Origin saveOrigin(@Valid @RequestBody UpdateWrapper<Origin> updateWrapper) {
        return adminService.saveOrigin(updateWrapper.getSave());
    }

    @PostMapping("/updateOrigin")
    public Origin updateOrigin(@Valid @RequestBody UpdateWrapper<Origin> updateWrapper) {
        return adminService.updateOrigin(updateWrapper.getUpdate());
    }

    @PostMapping("/deleteOrigin")
    public void deleteOrigin(@Valid @RequestBody UpdateWrapper<Origin> updateWrapper) {
        adminService.deleteOrigin(updateWrapper.getDeleteId());
    }

    @GetMapping("/origin")
    public List<Origin> findAllOrigins() {
        return adminService.findAllValidOrigins();
    }

    @PostMapping("/updateOrigins")
    public void updateOrigins(@Valid @RequestBody UpdateWrapper<Origin> updateWrapper){
        adminService.updateOrigins(updateWrapper.getSaveList(), updateWrapper.getDeleteList());
    }







    @PostMapping("/uom")
    public UOM saveUOM(@Valid @RequestBody UpdateWrapper<UOM> updateWrapper) {
        return adminService.saveUOM(updateWrapper.getSave());
    }

    @PostMapping("/updateUom")
    public UOM updateUOM(@Valid @RequestBody UpdateWrapper<UOM> updateWrapper) {
        return adminService.updateUOM(updateWrapper.getUpdate());
    }

    @PostMapping("/deleteUom")
    public void deleteUOM(@Valid @RequestBody UpdateWrapper<UOM> updateWrapper) {
        adminService.deleteUOM(updateWrapper.getDeleteId());
    }

    @GetMapping("/uom")
    public List<UOM> findAllUOMs() {
        return adminService.findAllValidUOMs();
    }

    @PostMapping("/updateUOMs")
    public void updateUOMs(@Valid @RequestBody UpdateWrapper<UOM> updateWrapper){
        adminService.updateUOMs(updateWrapper.getSaveList(), updateWrapper.getDeleteList());
    }







    @PostMapping("/item")
    public Item saveItem(@Valid @RequestBody UpdateWrapper<Item> updateWrapper) {
        return adminService.saveItem(updateWrapper.getSave());
    }

    @PostMapping("/updateItem")
    public Item updateItem(@Valid @RequestBody UpdateWrapper<Item> updateWrapper) {
        return adminService.updateItem(updateWrapper.getUpdate());
    }

    @PostMapping("/deleteItem")
    public void deleteItem(@Valid @RequestBody UpdateWrapper<Item> updateWrapper) {
        adminService.deleteItem(updateWrapper.getDeleteId());
    }

    @GetMapping("/item")
    public List<Item> findAllItems() {
        return adminService.findAllValidItems();
    }

//    @GetMapping("/itemByServiceId")
//    public List<Item> findAllItemsByServiceId(@RequestParam Integer id){return adminService.findAllValidItemsByServiceId(id);}

    @PostMapping("/updateItems")
    public void updateItems(@Valid @RequestBody UpdateWrapper<Item> updateWrapper){
        adminService.updateItems(updateWrapper.getSaveList(), updateWrapper.getDeleteList());
    }







    @PostMapping("/service")
    public Service saveService(@Valid @RequestBody UpdateWrapper<Service> updateWrapper) {
        return adminService.saveService(updateWrapper.getSave());
    }

    @PostMapping("/updateService")
    public Service updateService(@Valid @RequestBody UpdateWrapper<Service> updateWrapper) {
        return adminService.updateService(updateWrapper.getUpdate());
    }

    @PostMapping("/deleteService")
    public void deleteService(@Valid @RequestBody UpdateWrapper<Service> updateWrapper) {
        adminService.deleteService(updateWrapper.getDeleteId());
    }

    @GetMapping("/service")
    public List<Service> findAllServices() {
        return adminService.findAllValidServices();
    }

    @PostMapping("/updateServices")
    public void updateServices(@Valid @RequestBody UpdateWrapper<Service> updateWrapper){
        adminService.updateServices(updateWrapper.getSaveList(), updateWrapper.getDeleteList());
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
    @PostMapping("/employee")
    public Employee saveEmployee(@Valid @RequestBody AdminWrapper adminWrapper){
        String name=adminWrapper.getName();
        String username=adminWrapper.getUsername();
        String password=adminWrapper.getPassword();
        int positionId=adminWrapper.getPositionId();
        return adminService.saveEmployee(name, username, password, positionId);
    }

    @PostMapping("/updateEmployee")
    public Employee updateEmployee(@Valid @RequestBody UpdateWrapper<Employee> updateWrapper) {
        return adminService.updateEmployee(updateWrapper.getUpdate());
    }

    @PostMapping("/deleteEmployee")
    public void deleteEmployee(@Valid @RequestBody UpdateWrapper<Employee> updateWrapper) {
        adminService.deleteEmployee(updateWrapper.getDeleteId());
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

    @PostMapping("/updateProject")
    public void updateProject(@Valid @RequestBody UpdateWrapper<Project> updateWrapper) {
        adminService.updateProject(updateWrapper.getUpdate());
    }
}
