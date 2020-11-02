package com.example.arj.DAO;

import com.example.arj.Models.Item;
import com.example.arj.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemDao implements Dao<Item> {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item find(Integer id) {
        return itemRepository.getOne(id);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> findByIsValidIsTrue() {
        return itemRepository.findByIsValidIsTrue();
    }

//    public List<Item> findByIsValidTrueAndService_Id(Integer id) {return itemRepository.findByIsValidTrueAndService_Id(id);}

    public void delete(Item itemD) {
        Item item= itemRepository.getOne(itemD.getId());
        item.setValid(false);
        itemRepository.save(item);
    }

    public void delete(Integer id) {
        Item item= itemRepository.getOne(id);
        item.setValid(false);
        itemRepository.save(item);
    }
}
