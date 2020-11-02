package com.example.arj.Services;

import com.example.arj.DAO.*;
import com.example.arj.Models.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class AdminService {

    @Autowired
    PositionDao positionDao;

    @Autowired
    MakeDao makeDao;

    @Autowired
    OriginDao originDao;

    @Autowired
    UOMDao uomDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    ServiceDao serviceDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    ProjectDao projectDao;

    public List<Position> findAllValidPositions(){return positionDao.findByIsValidIsTrue();}

    public void updatePositions(List<Position> addPosition, List<Position> deletePosition) {
        for (Position position : addPosition)
            positionDao.save(position);

        for (Position position : deletePosition)
            positionDao.delete(position);
    }

    public List<Make> findAllValidMakes(){return makeDao.findByIsValidIsTrue();}

    public void updateMakes(List<Make> addMakes, List<Make> deleteMakes){
        for(Make make: addMakes)
            makeDao.save(make);

        for(Make make: deleteMakes)
            makeDao.delete(make);
    }

    public List<Origin> findAllValidOrigins(){return originDao.findByIsValidIsTrue();}

    public void updateOrigins(List<Origin> addOrigins, List<Origin> deleteOrigins){
        for(Origin origin: addOrigins)
            originDao.save(origin);

        for(Origin origin: deleteOrigins)
            originDao.delete(origin);
    }

    public List<UOM> findAllValidUOMs(){return uomDao.findByIsValidIsTrue();}

    public void updateUOMs(List<UOM> addUom, List<UOM> deleteUOM){
        for(UOM uom: addUom)
            uomDao.save(uom);

        for(UOM uom: deleteUOM)
            uomDao.delete(uom);
    }

    public List<Item> findAllValidItems(){return itemDao.findByIsValidIsTrue();}

    public List<Item> findAllValidItemsByServiceId(Integer id){
        /*
        Getting all the item of service ID and filtering with validation.
        */
        return serviceDao.find(id).getItems().stream().filter(item -> item.isValid()).collect(Collectors.toList());
    }

    public void updateItems(List<Item> addItems, List<Item> deleteItems){
        for(Item item: addItems)
            itemDao.save(item);

        for(Item item: deleteItems)
            itemDao.delete(item);
    }

    public List<Service> findAllValidServices(){return serviceDao.findByIsValidIsTrue();}

    public void updateServices(List<Service> addServices, List<Service> deleteService){
        for(Service service: addServices)
            serviceDao.save(service);

        for(Service service: deleteService)
            serviceDao.delete(service);
    }

    public Employee saveEmployee(String name, String username, String password, int positionId){
        Account account=new Account(username, password);
        Employee employee=new Employee();
        employee.setName(name);
        employee.setAccount(account);
        employee.setPosition(positionDao.find(positionId));
        return employeeDao.save(employee);
    }

    public Project createProject(String name, String code, int managerId, List<Integer> peIds){
        Project project=new Project(name, code);
        project.setManager(employeeDao.find(managerId));
        List<Employee> pes=new ArrayList<>();
        for(int peId: peIds)
            pes.add(employeeDao.find(peId));
        project.setPes(pes);
        return projectDao.save(project);
    }

}
