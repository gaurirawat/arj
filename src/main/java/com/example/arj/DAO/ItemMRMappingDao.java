package com.example.arj.DAO;

import com.example.arj.Models.ItemMRMapping;
import com.example.arj.Repositories.ItemMRMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMRMappingDao implements Dao<ItemMRMapping> {
    @Autowired
    ItemMRMappingRepository itemMRMappingRepository;

    @Override
    public ItemMRMapping find(Integer id) {
        return itemMRMappingRepository.getOne(id);
    }

    @Override
    public List<ItemMRMapping> findAll() {
        return itemMRMappingRepository.findAll();
    }

    @Override
    public ItemMRMapping save(ItemMRMapping itemMRMapping) {
        return itemMRMappingRepository.save(itemMRMapping);
    }

    @Override
    public ItemMRMapping update(ItemMRMapping itemMRMapping) {
        return itemMRMappingRepository.save(itemMRMapping);
    }

    public void delete(ItemMRMapping itemMRMapping) {
        itemMRMappingRepository.deleteById(itemMRMapping.getId());
    }

    public void delete(Integer id) {
        itemMRMappingRepository.deleteById(id);
    }
}
