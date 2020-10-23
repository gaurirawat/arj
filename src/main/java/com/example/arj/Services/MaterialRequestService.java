package com.example.arj.Services;

import com.example.arj.DAO.*;
import com.example.arj.Models.*;
import com.example.arj.Utils.ActionEnum;
import com.example.arj.Utils.StatusEnum;
import com.example.arj.Utils.Wrappers.ItemMRMappingWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class MaterialRequestService {
    @Autowired
    PositionDao positionDao;

    @Autowired
    MakeDao makeDao;

    @Autowired
    OriginDao originDao;

    @Autowired
    UOMDao uomDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    ServiceDao serviceDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    ProjectDao projectDao;

    @Autowired
    MaterialRequestDao materialRequestDao;

    @Autowired
    ItemMRMappingDao itemMRMappingDao;

    @Autowired
    TransactionDao transactionDao;

    public MaterialRequest createMaterialRequest(String areaFloor, Date doRequiredDelivery, String instruction, int serviceId, int projectId, int raisedById, List<ItemMRMappingWrapper> itemMRMappingWrappers){
        MaterialRequest materialRequest= new MaterialRequest();
        materialRequest.setAreaFloor(areaFloor);
        materialRequest.setDoRequiredDelivery(doRequiredDelivery);
        materialRequest.setInstruction(instruction);
        materialRequest.setProject(projectDao.find(projectId));
        materialRequest.setService(serviceDao.find(serviceId));

        Employee employee=employeeDao.find(raisedById);
        materialRequest.setCurrentLevelOfHierarchy(employee.getPosition().getHierarchy()+1);
        materialRequest.setRaisedBy(employee);
        materialRequestDao.save(materialRequest);

        for(ItemMRMappingWrapper itemMRMappingWrapper: itemMRMappingWrappers){
            ItemMRMapping itemMRMapping= new ItemMRMapping();
            itemMRMapping.setOrigin(originDao.find(itemMRMappingWrapper.getOriginId()));
            itemMRMapping.setMake(makeDao.find(itemMRMappingWrapper.getMakeId()));
            itemMRMapping.setItem(itemDao.find(itemMRMappingWrapper.getItemId()));
            itemMRMapping.setMaterialRequest(materialRequest);
            itemMRMappingDao.save(itemMRMapping);
        }

        logTransaction(ActionEnum.CREATE, employee, materialRequest);
        return materialRequest;
    }

    public Transaction logTransaction(ActionEnum action, Employee employee, MaterialRequest materialRequest){
        Transaction transaction=new Transaction(action, employee, materialRequest,employee.getPosition());
        return transactionDao.save(transaction);
    }

    public void approveMaterialRequest(int employeeId, int materialRequestId){
        Employee employee=employeeDao.find(employeeId);
        MaterialRequest materialRequest=materialRequestDao.find(materialRequestId);
        materialRequest.setCurrentLevelOfHierarchy(materialRequest.getCurrentLevelOfHierarchy()+1);
        if(employee.getPosition().isCanEnd())
            materialRequest.setStatus(StatusEnum.OPEN);
        materialRequestDao.save(materialRequest);

        logTransaction(ActionEnum.APPROVE, employee, materialRequest);
    }

    public void declineMaterialRequest(int employeeId, int materialRequestId, String remark){
        Employee employee=employeeDao.find(employeeId);
        MaterialRequest materialRequest= materialRequestDao.find(materialRequestId);
        materialRequest.setStatus(StatusEnum.DECLINED);
        materialRequest.setDoCancellation(Date.valueOf(LocalDate.now()));
        materialRequest.setRemark(remark);
        materialRequestDao.save(materialRequest);

        logTransaction(ActionEnum.DECLINE, employee, materialRequest);
    }

    public List<Project> findAssignedProjects(int employeeId){
        Employee employee=employeeDao.find(employeeId);
        List<Project> projects;
        if(isPM(employee))
            projects= employee.getPmProjects();
        else
            projects= employee.getPeProjects();

        for(int i=0;i<projects.size();++i){
            if(!projects.get(i).isValid()){
                projects.remove(projects.get(i));
                --i;
            }
        }
        return projects;
    }

    public boolean isPM(Employee employee){
        if(employee.getPosition().getHierarchy()==2)
            return true;
        return false;
    }

    public boolean isGM(Employee employee){
        if(employee.getPosition().getHierarchy()==3)
            return true;
        return false;
    }

    public boolean isDM(Employee employee){
        if(employee.getPosition().getHierarchy()==4)
            return true;
        return false;
    }

    public List<MaterialRequest> findAllPendingMaterialRequests(int employeeId){
        Employee employee=employeeDao.find(employeeId);
        if(isPM(employee))
            return materialRequestDao.findByCurrentLevelOfHierarchyAndStatusAndProject_Manager(employee.getPosition().getHierarchy(), StatusEnum.PENDING, employee);
        else if(isGM(employee) || isDM(employee))
            return materialRequestDao.findByCurrentLevelOfHierarchyAndStatus(employee.getPosition().getHierarchy(), StatusEnum.PENDING);
        else
            return materialRequestDao.findByStatus(StatusEnum.OPEN);
    }

}
