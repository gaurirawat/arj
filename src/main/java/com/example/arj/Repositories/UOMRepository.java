package com.example.arj.Repositories;

import com.example.arj.Models.UOM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UOMRepository extends JpaRepository<UOM, Integer> {
    public List<UOM> findByIsValidIsTrue();

}
