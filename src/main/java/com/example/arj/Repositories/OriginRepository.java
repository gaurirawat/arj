package com.example.arj.Repositories;

import com.example.arj.Models.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Integer> {
    public List<Origin> findByIsValidIsTrue();

}
