package com.example.arj.DAO;

import com.example.arj.Models.UOM;
import com.example.arj.Repositories.UOMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UOMDao implements Dao<UOM> {

    @Autowired
    UOMRepository uomRepository;

    @Override
    public UOM find(Integer id){return uomRepository.getOne(id);}

    @Override
    public List<UOM> findAll(){return uomRepository.findAll();}

    @Override
    public UOM save(UOM uom){ return uomRepository.save(uom);}

    @Override
    public UOM update(UOM uom){ return uomRepository.save(uom);}

    public List<UOM> findByIsValidIsTrue() {
        return uomRepository.findByIsValidIsTrue();
    }

    public void delete(UOM uom){
        uom.setValid(false);
        uomRepository.save(uom);
    }

    public void delete(Integer id){
        UOM uom=uomRepository.getOne(id);
        uom.setValid(false);
        uomRepository.save(uom);
    }
}
