package com.example.arj.DAO;

import com.example.arj.Models.Employee;
import com.example.arj.Models.MaterialRequest;
import com.example.arj.Repositories.MaterialRequestRepository;
import com.example.arj.Utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public List<MaterialRequest> findByCurrentLevelOfHierarchyAndStatusAndProject_Manager(int currentLevelOfHierarchy, StatusEnum statusEnum, Employee employee){
        return materialRequestRepository.findByCurrentLevelOfHierarchyAndStatusAndProject_Manager(currentLevelOfHierarchy,statusEnum,employee);
    }

    public List<MaterialRequest> findByCurrentLevelOfHierarchyAndStatus(int currentLevelOfHierarchy, StatusEnum statusEnum){
        return materialRequestRepository.findByCurrentLevelOfHierarchyAndStatus(currentLevelOfHierarchy,statusEnum);
    }

    public List<MaterialRequest> findByStatus( StatusEnum statusEnum){
        return materialRequestRepository.findByStatus(statusEnum);
    }
}
