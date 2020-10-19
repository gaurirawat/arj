package com.example.arj.DAO;

import com.example.arj.models.Position;
import com.example.arj.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public void delete(Position position) {
        positionRepository.deleteById(position.getId());
    }

    @Override
    public void delete(Integer id) {
        positionRepository.deleteById(id);
    }
}
