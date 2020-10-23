package com.example.arj.Controller;

import com.example.arj.DAO.EmployeeDao;
import com.example.arj.DAO.MaterialRequestDao;
import com.example.arj.Models.Employee;
import com.example.arj.Models.ItemMRMapping;
import com.example.arj.Models.MaterialRequest;
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
    MaterialRequestDao materialRequestDao;

    @GetMapping
    public List<MaterialRequest> test(){
        return materialRequestDao.findAll();
    }
    @Autowired
    MaterialRequestService materialRequestService;

    @PostMapping("/create")
    public MaterialRequest createMaterialRequest(@Valid @RequestBody MaterialRequestWrapper materialRequestWrapper){
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

    @PostMapping("/decline")
    public void declineMaterialRequest(@Valid @RequestBody MaterialRequestWrapper materialRequestWrapper){
        int employeeId=materialRequestWrapper.getEmployeeId();
        int materialRequestId=materialRequestWrapper.getMaterialRequestId();
        String remark=materialRequestWrapper.getRemark();
        materialRequestService.declineMaterialRequest(employeeId,materialRequestId,remark);
    }
}
