package com.example.arj.Repositories;

import com.example.arj.Models.ItemMRMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMRMappingRepository extends JpaRepository<ItemMRMapping, Integer> {
}
