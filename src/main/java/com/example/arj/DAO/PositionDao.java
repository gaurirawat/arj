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
        return positionRepository.save(position);
    }

    public List<Position> findByIsValidIsTrue() {
        return positionRepository.findByIsValidIsTrue();
    }

    public void delete(Position positionD) {
        Position position=positionRepository.getOne(positionD.getId());
        position.setValid(false);
        positionRepository.save(position);
    }

    public void delete(Integer id) {
        Position position=positionRepository.getOne(id);
        position.setValid(false);
        positionRepository.save(position);
    }
}
