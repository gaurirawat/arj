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
        Make dbMake=makeRepository.getOne(make.getId());
        dbMake.setValue(make.getValue());
        return makeRepository.save(dbMake);
    }

    public List<Make> findByIsValidIsTrue() {
        return makeRepository.findByIsValidIsTrue();
    }

    public void delete(Make makeD) {
        Make make= makeRepository.getOne(makeD.getId());
        make.setIsValid(false);
        makeRepository.save(make);
    }

    public void delete(Integer id) {
        Make make= makeRepository.getOne(id);
        make.setIsValid(false);
        makeRepository.save(make);
    }
}
