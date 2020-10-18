package com.example.arj.repositories;

import com.example.arj.models.Item;
import com.example.arj.models.ItemMRMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMRMappingRepository extends JpaRepository<ItemMRMapping, Integer> {
}
