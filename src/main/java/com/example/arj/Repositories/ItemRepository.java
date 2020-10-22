package com.example.arj.Repositories;

import com.example.arj.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    public List<Item> findByIsValidIsTrue();

    public List<Item> findByIsValidTrueAndService_Id(Integer id);

//    public List<Item> findByValidIsTrueAndService_Id(Integer id);
}
