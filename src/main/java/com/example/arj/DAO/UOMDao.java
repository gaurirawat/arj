package com.example.arj.DAO;

import com.example.arj.models.UOM;
import com.example.arj.repositories.UOMRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UOMDao implements Dao<UOM> {

    @Autowired
    UOMRepository uomRepository;

    public UOM find(Integer id){return uomRepository.getOne(id);}

    public List<UOM> findAll(){return uomRepository.findAll();}

    public UOM save(UOM uom){ return uomRepository.save(uom);}

    public UOM update(UOM uom){ return uomRepository.save(uom);}

    public void delete(UOM uom){uomRepository.deleteById(uom.getId());}

    public void delete(Integer id){uomRepository.deleteById(id);}
}