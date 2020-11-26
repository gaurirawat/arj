package com.example.arj.Controller;

import com.example.arj.DAO.EmployeeDao;
import com.example.arj.DAO.MaterialRequestDao;
import com.example.arj.Models.*;
import com.example.arj.Services.MaterialRequestService;
import com.example.arj.Utils.Wrappers.ItemMRMappingWrapper;
import com.example.arj.Utils.Wrappers.MaterialRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("materialRequest")
public class MaterialRequestController {

    @Autowired
    MaterialRequestService materialRequestService;

    @GetMapping
    public List<MaterialRequest> test(){
        return materialRequestService.findAll();
    }

    @PostMapping("/create")
    public MaterialRequest createMaterialRequest(@Valid @RequestBody MaterialRequestWrapper materialRequestWrapper){
        System.out.println(materialRequestWrapper.toString());
        String areaFloor=materialRequestWrapper.getAreaFloor();
        Date doRequiredDelivery=materialRequestWrapper.getDoRequiredDelivery();
        String instruction= materialRequestWrapper.getInstruction();
        int serviceId=materialRequestWrapper.getServiceId();
        int projectId=materialRequestWrapper.getProjectId();
        int raisedById=materialRequestWrapper.getRaisedById();
        List<ItemMRMappingWrapper> itemMRMappingWrappers= materialRequestWrapper.getItemMRMappingWrappers();
        return materialRequestService.createMaterialRequest(areaFloor, doRequiredDelivery, instruction, serviceId, projectId, raisedById, itemMRMappingWrappers);
    }

    @PostMapping("/approve")
    public void approveMaterialRequest(@Valid @RequestBody MaterialRequestWrapper materialRequestWrapper){
        int employeeId=materialRequestWrapper.getEmployeeId();
        int materialRequestId=materialRequestWrapper.getMaterialRequestId();
        materialRequestService.approveMaterialRequest(employeeId,materialRequestId);
    }

    @PostMapping("/close")
    public void closeMaterialRequest(@Valid @RequestBody MaterialRequestWrapper materialRequestWrapper){
        int employeeId=materialRequestWrapper.getEmployeeId();
        int materialRequestId=materialRequestWrapper.getMaterialRequestId();
        materialRequestService.closeMaterialRequest(employeeId,materialRequestId);
    }

    @PostMapping("/reopen")
    public void reopenMaterialRequest(@Valid @RequestBody MaterialRequestWrapper materialRequestWrapper){
        int employeeId=materialRequestWrapper.getEmployeeId();
        int materialRequestId=materialRequestWrapper.getMaterialRequestId();
        materialRequestService.reopenMaterialRequest(employeeId,materialRequestId);
    }

    @PostMapping("/decline")
    public void declineMaterialRequest(@Valid @RequestBody MaterialRequestWrapper materialRequestWrapper){
        int employeeId=materialRequestWrapper.getEmployeeId();
        int materialRequestId=materialRequestWrapper.getMaterialRequestId();
        String remark=materialRequestWrapper.getRemark();
        materialRequestService.declineMaterialRequest(employeeId,materialRequestId,remark);
    }

    @GetMapping("/findAllProcessedMaterialRequest")
    public List<MaterialRequest> findAllProcessedMaterialRequest(@RequestParam Integer employeeId){
        return materialRequestService.findAllProcessedMaterialRequest(employeeId);
    }

    @GetMapping("/project")
    public List<Project> findAssignedProjects(@RequestParam int employeeId){
        return materialRequestService.findAssignedProjects(employeeId);
    }

    @GetMapping("/findAllPendingMaterialRequests")
    public List<MaterialRequest> findAllPendingMaterialRequests(@RequestParam int employeeId){
        return materialRequestService.findAllPendingMaterialRequests(employeeId);
    }

    @GetMapping("getPurchaseOrders")
    public List<PurchaseOrder> findAllPurchaseOrdersByMaterialRequest(@RequestParam Integer materialRequestId){
        return materialRequestService.findAllPurchaseOrdersByMaterialRequest(materialRequestId);
    }

}
