package com.example.arj.Utils.Wrappers;

import com.example.arj.Models.Employee;
import com.example.arj.Models.ItemMRMapping;

import java.sql.Date;
import java.util.List;

public class MaterialRequestWrapper {
    private String areaFloor;
    private String remark;
    private String instruction;

    private Date doRequiredDelivery;

    private int serviceId;
    private int projectId;
    private int raisedById;
    private int employeeId;
    private int materialRequestId;

    private List<ItemMRMappingWrapper> itemMRMappingWrappers;

    public String getAreaFloor() {
        return areaFloor;
    }

    public void setAreaFloor(String areaFloor) {
        this.areaFloor = areaFloor;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Date getDoRequiredDelivery() {
        return doRequiredDelivery;
    }

    public void setDoRequiredDelivery(Date doRequiredDelivery) {
        this.doRequiredDelivery = doRequiredDelivery;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getRaisedById() {
        return raisedById;
    }

    public void setRaisedById(int raisedById) {
        this.raisedById = raisedById;
    }

    public int getMaterialRequestId() {
        return materialRequestId;
    }

    public void setMaterialRequestId(int materialRequestId) {
        this.materialRequestId = materialRequestId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<ItemMRMappingWrapper> getItemMRMappingWrappers() {
        return itemMRMappingWrappers;
    }

    public void setItemMRMappingWrappers(List<ItemMRMappingWrapper> itemMRMappingWrappers) {
        this.itemMRMappingWrappers = itemMRMappingWrappers;
    }

    @Override
    public String toString() {
        return "MaterialRequestWrapper{" +
                "areaFloor='" + areaFloor + '\'' +
                ", remark='" + remark + '\'' +
                ", instruction='" + instruction + '\'' +
                ", doRequiredDelivery=" + doRequiredDelivery +
                ", serviceId=" + serviceId +
                ", projectId=" + projectId +
                ", raisedById=" + raisedById +
                ", employeeId=" + employeeId +
                ", materialRequestId=" + materialRequestId +
                ", itemMRMappingWrappers=" + itemMRMappingWrappers +
                '}';
    }

}
