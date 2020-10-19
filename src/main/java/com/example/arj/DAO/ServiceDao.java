package com.example.arj.DAO;

import com.example.arj.models.Service;
import com.example.arj.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceDao implements Dao<Service> {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Service find(Integer id) {
        return serviceRepository.getOne(id);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service update(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public void delete(Service service) {
        serviceRepository.deleteById(service.getId());
    }

    @Override
    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }
}
