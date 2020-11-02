package com.example.arj.Repositories;

import com.example.arj.Models.Employee;
import com.example.arj.Models.MaterialRequest;
import com.example.arj.Utils.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRequestRepository extends JpaRepository<MaterialRequest, Integer> {
    public List<MaterialRequest> findByCurrentLevelOfHierarchyAndStatusAndProject_Manager(Integer currentLevelOfHierarchy, StatusEnum statusEnum, Employee employee);
    public List<MaterialRequest> findByCurrentLevelOfHierarchyAndStatus(Integer currentLevelOfHierarchy, StatusEnum statusEnum);
    public List<MaterialRequest> findByStatus(StatusEnum statusEnum);
    public List<MaterialRequest> findByRaisedBy_Id(Integer id);
    public List<MaterialRequest> findByProject_Manager_IdAndCurrentLevelOfHierarchyGreaterThan(Integer id,Integer hierarchy);
    public List<MaterialRequest> findByCurrentLevelOfHierarchyGreaterThan(Integer hierarchy);

}
