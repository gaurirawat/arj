package com.example.arj.Repositories;

import com.example.arj.Models.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakeRepository extends JpaRepository<Make, Integer> {
    public List<Make> findByIsValidIsTrue();
}
