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
    public void addPosition(@Valid @RequestBody UpdateWrapper<Position> updateWrapper) {
        adminService.addPosition(updateWrapper.getAdd());
    }

    @PostMapping("/updatePosition")
    public void updatePosition(@Valid @RequestBody UpdateWrapper<Position> updateWrapper) {
        adminService.updatePosition(updateWrapper.getUpdate());
    }

    @DeleteMapping("/position")
    public void deletePosition(@Valid @RequestBody UpdateWrapper<Position> updateWrapper) {
        adminService.deletePosition(updateWrapper.getDeleteId());
    }

    @GetMapping("/position")
    public List<Position> findAllPositions() {
        return adminService.findAllValidPositions();
    }

    @PostMapping("/updatePositions")
    public void updatePositions(@Valid @RequestBody UpdateWrapper<Position> updateWrapper){
//        List<Position> addPositions=updateWrapper.getAddList();
//        List<Position> deletePositions=updateWrapper.getDeleteList();
        adminService.updatePositions(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }






    @PostMapping("/make")
    public void addMake(@Valid @RequestBody UpdateWrapper<Make> updateWrapper) {
        adminService.addMake(updateWrapper.getAdd());
    }

    @PostMapping("/updateMake")
    public void updateMake(@Valid @RequestBody UpdateWrapper<Make> updateWrapper) {
        adminService.updateMake(updateWrapper.getUpdate());
    }

    @DeleteMapping("/make")
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
    @PostMapping("/updateMakes")
    public void updateMakes(@Valid @RequestBody UpdateWrapper<Make> updateWrapper){
        adminService.updateMakes(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }







    @PostMapping("/origin")
    public void addOrigin(@Valid @RequestBody UpdateWrapper<Origin> updateWrapper) {
        adminService.addOrigin(updateWrapper.getAdd());
    }

    @PostMapping("/updateOrigin")
    public void updateOrigin(@Valid @RequestBody UpdateWrapper<Origin> updateWrapper) {
        adminService.updateOrigin(updateWrapper.getUpdate());
    }

    @DeleteMapping("/origin")
    public void deleteOrigin(@Valid @RequestBody UpdateWrapper<Origin> updateWrapper) {
        adminService.deleteOrigin(updateWrapper.getDeleteId());
    }

    @GetMapping("/origin")
    public List<Origin> findAllOrigins() {
        return adminService.findAllValidOrigins();
    }

    @PostMapping("/updateOrigins")
    public void updateOrigins(@Valid @RequestBody UpdateWrapper<Origin> updateWrapper){
        adminService.updateOrigins(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }







    @PostMapping("/uom")
    public void addUOM(@Valid @RequestBody UpdateWrapper<UOM> updateWrapper) {
        adminService.addUOM(updateWrapper.getAdd());
    }

    @PostMapping("/updateUom")
    public void updateUOM(@Valid @RequestBody UpdateWrapper<UOM> updateWrapper) {
        adminService.updateUOM(updateWrapper.getUpdate());
    }

    @DeleteMapping("/uom")
    public void deleteUOM(@Valid @RequestBody UpdateWrapper<UOM> updateWrapper) {
        adminService.deleteUOM(updateWrapper.getDeleteId());
    }

    @GetMapping("/uom")
    public List<UOM> findAllUOMs() {
        return adminService.findAllValidUOMs();
    }

    @PostMapping("/updateUOMs")
    public void updateUOMs(@Valid @RequestBody UpdateWrapper<UOM> updateWrapper){
        adminService.updateUOMs(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }







    @PostMapping("/item")
    public void addItem(@Valid @RequestBody UpdateWrapper<Item> updateWrapper) {
        adminService.addItem(updateWrapper.getAdd());
    }

    @PostMapping("/updateItem")
    public void updateItem(@Valid @RequestBody UpdateWrapper<Item> updateWrapper) {
        adminService.updateItem(updateWrapper.getUpdate());
    }

    @DeleteMapping("/item")
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
        adminService.updateItems(updateWrapper.getAddList(), updateWrapper.getDeleteList());
    }







    @PostMapping("/service")
    public void addService(@Valid @RequestBody UpdateWrapper<Service> updateWrapper) {
        adminService.addService(updateWrapper.getAdd());
    }

    @PostMapping("/updateService")
    public void updateService(@Valid @RequestBody UpdateWrapper<Service> updateWrapper) {
        adminService.updateService(updateWrapper.getUpdate());
    }

    @DeleteMapping("/service")
    public void deleteService(@Valid @RequestBody UpdateWrapper<Service> updateWrapper) {
        adminService.deleteService(updateWrapper.getDeleteId());
    }

    @GetMapping("/service")
    public List<Service> findAllServices() {
        return adminService.findAllValidServices();
    }

    @PostMapping("/updateServices")
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
    @PostMapping("/employee")
    public Employee addEmployee(@Valid @RequestBody AdminWrapper adminWrapper){
        String name=adminWrapper.getName();
        String username=adminWrapper.getUsername();
        String password=adminWrapper.getPassword();
        int positionId=adminWrapper.getPositionId();
        return adminService.addEmployee(name, username, password, positionId);
    }

    @PostMapping("/updateEmployee")
    public void updateEmployee(@Valid @RequestBody UpdateWrapper<Employee> updateWrapper) {
        adminService.updateEmployee(updateWrapper.getUpdate());
    }

    @DeleteMapping("/employee")
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
