package com.example.arj.DAO;

import com.example.arj.Models.Make;
import com.example.arj.Repositories.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MakeDao implements Dao<Make> {
    @Autowired
    MakeRepository makeRepository;

    @Override
    public Make find(Integer id) {
        return makeRepository.getOne(id);
    }

    @Override
    public List<Make> findAll() {
        return makeRepository.findAll();
    }

    @Override
    public Make save(Make make) {
        return makeRepository.save(make);
    }

    @Override
    public Make update(Make make) {
        return makeRepository.save(make);
    }

    public List<Make> findByIsValidIsTrue() {
        return makeRepository.findByIsValidIsTrue();
    }

    public void delete(Make make) {
        make.setValid(false);
        makeRepository.save(make);
    }

    public void delete(Integer id) {
        Make make= makeRepository.getOne(id);
        make.setValid(false);
        makeRepository.save(make);
    }
}
