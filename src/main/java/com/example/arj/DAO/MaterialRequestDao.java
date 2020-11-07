package com.example.arj.DAO;

import com.example.arj.Models.MaterialRequest;
import com.example.arj.Repositories.MaterialRequestRepository;
import com.example.arj.Utils.Enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.MatrixVariable;

import java.util.List;

@Component
public class MaterialRequestDao implements Dao<MaterialRequest> {
    @Autowired
    MaterialRequestRepository materialRequestRepository;

    @Override
    public MaterialRequest find(Integer id) {
        return materialRequestRepository.getOne(id);
    }

    @Override
    public List<MaterialRequest> findAll() {
        return materialRequestRepository.findAll();
    }

    @Override
    public MaterialRequest save(MaterialRequest materialRequest) {
        return materialRequestRepository.save(materialRequest);
    }

    @Override
    public MaterialRequest update(MaterialRequest materialRequest) {
        return materialRequestRepository.save(materialRequest);
    }

    public List<MaterialRequest> findByCurrentLevelOfHierarchyAndStatusAndProject_Manager_Id(int currentLevelOfHierarchy, StatusEnum statusEnum, int employeeId){
        return materialRequestRepository.findByCurrentLevelOfHierarchyAndStatusAndProject_Manager_Id(currentLevelOfHierarchy,statusEnum,employeeId);
    }

    public List<MaterialRequest> findByCurrentLevelOfHierarchyAndStatus(int currentLevelOfHierarchy, StatusEnum statusEnum){
        return materialRequestRepository.findByCurrentLevelOfHierarchyAndStatus(currentLevelOfHierarchy,statusEnum);
    }

    public List<MaterialRequest> findByProject_Manager_IdAndCurrentLevelOfHierarchyGreaterThan(Integer id, Integer hierarchy){
        return materialRequestRepository.findByProject_Manager_IdAndCurrentLevelOfHierarchyGreaterThan(id,hierarchy);
    }

    public List<MaterialRequest> findByCurrentLevelOfHierarchyGreaterThan(Integer hierarchy){
        return materialRequestRepository.findByCurrentLevelOfHierarchyGreaterThan(hierarchy);
    }

    public List<MaterialRequest> findByStatus( StatusEnum statusEnum){
        return materialRequestRepository.findByStatus(statusEnum);
    }

    public List<MaterialRequest> findByRaisedBy(Integer id){
        return materialRequestRepository.findByRaisedBy_Id(id);
    }
}
