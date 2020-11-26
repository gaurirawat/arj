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
    public UOM update(UOM uom){
        UOM dbUom=uomRepository.getOne(uom.getId());
        dbUom.setUnit(uom.getUnit());
        return uomRepository.save(dbUom);
    }

    public List<UOM> findByIsValidIsTrue() {
        return uomRepository.findByIsValidIsTrue();
    }

    public void delete(UOM uomD){
        UOM uom=uomRepository.getOne(uomD.getId());
        uom.setIsValid(false);
        uomRepository.save(uom);
    }

    public void delete(Integer id){
        UOM uom=uomRepository.getOne(id);
        uom.setIsValid(false);
        uomRepository.save(uom);
    }
}
