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

    public void updatePositions(List<Position> savePosition, List<Position> deletePosition) {
        for (Position position : savePosition)
            positionDao.save(position);

        for (Position position : deletePosition)
            positionDao.delete(position);
    }

    public Position savePosition(Position position){ return positionDao.save(position);}

    public Position updatePosition(Position position){ return positionDao.update(position);}

    public void deletePosition(int positionId){ positionDao.delete(positionId);}







    public List<Make> findAllValidMakes(){return makeDao.findByIsValidIsTrue();}

    public void updateMakes(List<Make> saveMakes, List<Make> deleteMakes){
        for(Make make: saveMakes)
            makeDao.save(make);

        for(Make make: deleteMakes)
            makeDao.delete(make);
    }

    public Make saveMake(Make make){ return makeDao.save(make);}

    public Make updateMake(Make make){return makeDao.update(make);}

    public void deleteMake(int makeId){ makeDao.delete(makeId);}







    public List<Origin> findAllValidOrigins(){return originDao.findByIsValidIsTrue();}

    public void updateOrigins(List<Origin> saveOrigins, List<Origin> deleteOrigins){
        for(Origin origin: saveOrigins)
            originDao.save(origin);

        for(Origin origin: deleteOrigins)
            originDao.delete(origin);
    }

    public Origin saveOrigin(Origin origin){ return originDao.save(origin);}

    public Origin updateOrigin(Origin origin){ return originDao.update(origin);}

    public void deleteOrigin(int originId){ originDao.delete(originId);}







    public List<UOM> findAllValidUOMs(){return uomDao.findByIsValidIsTrue();}

    public void updateUOMs(List<UOM> saveUom, List<UOM> deleteUOM){
        for(UOM uom: saveUom)
            uomDao.save(uom);

        for(UOM uom: deleteUOM)
            uomDao.delete(uom);
    }

    public UOM saveUOM(UOM uom){ return uomDao.save(uom);}

    public UOM updateUOM(UOM uom){ return uomDao.update(uom);}

    public void deleteUOM(int uomId){ uomDao.delete(uomId);}







    public List<Item> findAllValidItems(){return itemDao.findByIsValidIsTrue();}

    public List<Item> findAllValidItemsByServiceId(Integer id){
//        Getting all the item of service ID and filtering with validation.
        return serviceDao.find(id).getItems().stream().filter(item -> item.getIsValid()).collect(Collectors.toList());
    }

    public void updateItems(List<Item> saveItems, List<Item> deleteItems){
        for(Item item: saveItems)
            itemDao.save(item);

        for(Item item: deleteItems)
            itemDao.delete(item);
    }

    public Item saveItem(Item item){ return itemDao.save(item);}

    public Item updateItem(Item item){ return itemDao.update(item);}

    public void deleteItem(int itemId){ itemDao.delete(itemId);}







    public List<Service> findAllValidServices(){return serviceDao.findByIsValidIsTrue();}

    public void updateServices(List<Service> saveServices, List<Service> deleteService){
        for(Service service: saveServices)
            serviceDao.save(service);

        for(Service service: deleteService)
            serviceDao.delete(service);
    }

    public Service saveService(Service service){ return serviceDao.save(service);}

    public Service updateService(Service service){ return serviceDao.update(service);}

    public void deleteService(int serviceId){ serviceDao.delete(serviceId);}







    public Employee saveEmployee(String name, String username, String password, int positionId){
        Account account=new Account(username, password);
        Employee employee=new Employee();
        employee.setName(name);
        employee.setAccount(account);
        employee.setPosition(positionDao.find(positionId));
        return employeeDao.save(employee);
    }

    public void deleteEmployee(int employeeId){ employeeDao.delete(employeeId);}

    public Employee updateEmployee(Employee employee){ return employeeDao.update(employee);}







    public Project createProject(String name, String code, int managerId, List<Integer> peIds){
        Project project=new Project(name, code);
        project.setManager(employeeDao.find(managerId));
        List<Employee> pes=new ArrayList<>();
        for(int peId: peIds)
            pes.add(employeeDao.find(peId));
        project.setPes(pes);
        return projectDao.save(project);
    }

    public Project updateProject(Project project){ return projectDao.update(project);}
}
