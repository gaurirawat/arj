package com.example.arj.repositories;

import com.example.arj.models.MaterialRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRequestRepository extends JpaRepository<MaterialRequest, Integer> {
}
