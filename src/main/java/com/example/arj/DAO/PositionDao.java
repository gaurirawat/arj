package com.example.arj.DAO;

import com.example.arj.Models.Position;
import com.example.arj.Repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PositionDao implements Dao<Position> {

    @Autowired
    PositionRepository positionRepository;

    @Override
    public Position find(Integer id) {
        return positionRepository.getOne(id);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position save(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public Position update(Position position) {
        Position dbPosition=positionRepository.getOne(position.getId());
        dbPosition.setName(position.getName());
        dbPosition.setCode(position.getCode());
        dbPosition.setHierarchy(position.getHierarchy());
        dbPosition.setCanCreate(position.isCanCreate());
        dbPosition.setCanEnd(position.isCanEnd());
        return positionRepository.save(dbPosition);
    }

    public List<Position> findByIsValidIsTrue() {
        return positionRepository.findByIsValidIsTrue();
    }

    public void delete(Position positionD) {
        Position position=positionRepository.getOne(positionD.getId());
        position.setIsValid(false);
        positionRepository.save(position);
    }

    public void delete(Integer id) {
        Position position=positionRepository.getOne(id);
        position.setIsValid(false);
        positionRepository.save(position);
    }
}
