package com.example.arj.Repositories;

import com.example.arj.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    public List<Item> findByIsValidIsTrue();
}