package com.example.arj.Controller;

import com.example.arj.Models.Employee;
import com.example.arj.Models.ItemMRMapping;
import com.example.arj.Models.MaterialRequest;
import com.example.arj.Services.MaterialRequestService;
import com.example.arj.Utils.Wrappers.MaterialRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("materialRequest")
public class MaterialRequestController {

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
        List<ItemMRMapping> itemMRMappings= materialRequestWrapper.getItemMRMappings();
        return materialRequestService.createMaterialRequest(areaFloor, doRequiredDelivery, instruction, serviceId, projectId, raisedById, itemMRMappings);
    }

    @PostMapping("/approve")
    public void approveMaterialRequest(@Valid @RequestBody MaterialRequestWrapper materialRequestWrapper){
        Employee employee=materialRequestWrapper.getEmployee();
        int materialRequestId=materialRequestWrapper.getMaterialRequestId();
        materialRequestService.approveMaterialRequest(employee,materialRequestId);
    }

    @PostMapping("/decline")
    public void declineMaterialRequest(@Valid @RequestBody MaterialRequestWrapper materialRequestWrapper){
        Employee employee=materialRequestWrapper.getEmployee();
        int materialRequestId=materialRequestWrapper.getMaterialRequestId();
        String remark=materialRequestWrapper.getRemark();
        materialRequestService.declineMaterialRequest(employee,materialRequestId,remark);
    }
}
