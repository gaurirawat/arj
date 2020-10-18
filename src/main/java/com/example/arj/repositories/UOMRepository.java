package com.example.arj.repositories;

import com.example.arj.models.UOM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UOMRepository extends JpaRepository<UOM, Integer> {
}
