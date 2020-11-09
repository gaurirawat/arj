package com.example.arj.DAO;

import com.example.arj.Models.Origin;
import com.example.arj.Repositories.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OriginDao implements Dao<Origin> {
    @Autowired
    OriginRepository originRepository;

    @Override
    public Origin find(Integer id) {
        return originRepository.getOne(id);
    }

    @Override
    public List<Origin> findAll() {
        return originRepository.findAll();
    }

    @Override
    public Origin save(Origin origin) {
        return originRepository.save(origin);
    }

    @Override
    public Origin update(Origin origin) {
        Origin dbOrigin=originRepository.getOne(origin.getId());
        dbOrigin.setValue(origin.getValue());
        return originRepository.save(dbOrigin);
    }

    public List<Origin> findByIsValidIsTrue() {
        return originRepository.findByIsValidIsTrue();
    }

    public void delete(Origin originD) {
        Origin origin= originRepository.getOne(originD.getId());
        origin.setValid(false);
        originRepository.save(origin);
    }

    public void delete(Integer id) {
        Origin origin= originRepository.getOne(id);
        origin.setValid(false);
        originRepository.save(origin);
    }
}
