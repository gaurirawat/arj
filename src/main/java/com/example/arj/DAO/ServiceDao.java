package com.example.arj.DAO;

import com.example.arj.Models.Item;
import com.example.arj.Models.Service;
import com.example.arj.Repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceDao implements Dao<Service> {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ItemDao itemDao;

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
        Service dbService= serviceRepository.getOne(service.getId());
        dbService.setName(service.getName());
        dbService.setCode(service.getCode());
        List<Item> items=new ArrayList<Item>();
        for(Item item: service.getItems())
            items.add(itemDao.find(item.getId()));
        dbService.setItems(items);
        return serviceRepository.save(dbService);
    }

    public List<Service> findByIsValidIsTrue() {
        return serviceRepository.findByIsValidIsTrue();
    }

    public void delete(Service serviceD) {
        Service service=serviceRepository.getOne(serviceD.getId());
        service.setIsValid(false);
        serviceRepository.save(service);
    }

    public void delete(Integer id) {
        Service service=serviceRepository.getOne(id);
        service.setIsValid(false);
        serviceRepository.save(service);
    }
}
