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

    public void addPosition(Position position){ positionDao.save(position);}

    public void updatePosition(Position position){ positionDao.update(position);}

    public void deletePosition(int positionId){ positionDao.delete(positionId);}







    public List<Make> findAllValidMakes(){return makeDao.findByIsValidIsTrue();}

    public void updateMakes(List<Make> addMakes, List<Make> deleteMakes){
        for(Make make: addMakes)
            makeDao.save(make);

        for(Make make: deleteMakes)
            makeDao.delete(make);
    }

    public void addMake(Make make){ makeDao.save(make);}

    public void updateMake(Make make){ makeDao.update(make);}

    public void deleteMake(int makeId){ makeDao.delete(makeId);}







    public List<Origin> findAllValidOrigins(){return originDao.findByIsValidIsTrue();}

    public void updateOrigins(List<Origin> addOrigins, List<Origin> deleteOrigins){
        for(Origin origin: addOrigins)
            originDao.save(origin);

        for(Origin origin: deleteOrigins)
            originDao.delete(origin);
    }

    public void addOrigin(Origin origin){ originDao.save(origin);}

    public void updateOrigin(Origin origin){ originDao.update(origin);}

    public void deleteOrigin(int originId){ originDao.delete(originId);}







    public List<UOM> findAllValidUOMs(){return uomDao.findByIsValidIsTrue();}

    public void updateUOMs(List<UOM> addUom, List<UOM> deleteUOM){
        for(UOM uom: addUom)
            uomDao.save(uom);

        for(UOM uom: deleteUOM)
            uomDao.delete(uom);
    }

    public void addUOM(UOM uom){ uomDao.save(uom);}

    public void updateUOM(UOM uom){ uomDao.update(uom);}

    public void deleteUOM(int uomId){ uomDao.delete(uomId);}







    public List<Item> findAllValidItems(){return itemDao.findByIsValidIsTrue();}

    public List<Item> findAllValidItemsByServiceId(Integer id){
//        Getting all the item of service ID and filtering with validation.
        return serviceDao.find(id).getItems().stream().filter(item -> item.isValid()).collect(Collectors.toList());
    }

    public void updateItems(List<Item> addItems, List<Item> deleteItems){
        for(Item item: addItems)
            itemDao.save(item);

        for(Item item: deleteItems)
            itemDao.delete(item);
    }

    public void addItem(Item item){ itemDao.save(item);}

    public void updateItem(Item item){ itemDao.update(item);}

    public void deleteItem(int itemId){ itemDao.delete(itemId);}







    public List<Service> findAllValidServices(){return serviceDao.findByIsValidIsTrue();}

    public void updateServices(List<Service> addServices, List<Service> deleteService){
        for(Service service: addServices)
            serviceDao.save(service);

        for(Service service: deleteService)
            serviceDao.delete(service);
    }

    public void addService(Service service){ serviceDao.save(service);}

    public void updateService(Service service){ serviceDao.update(service);}

    public void deleteService(int serviceId){ serviceDao.delete(serviceId);}







    public Employee addEmployee(String name, String username, String password, int positionId){
        Account account=new Account(username, password);
        Employee employee=new Employee();
        employee.setName(name);
        employee.setAccount(account);
        employee.setPosition(positionDao.find(positionId));
        return employeeDao.save(employee);
    }

    public void deleteEmployee(int employeeId){ employeeDao.delete(employeeId);}

    public void updateEmployee(Employee employee){ employeeDao.update(employee);}







    public Project createProject(String name, String code, int managerId, List<Integer> peIds){
        Project project=new Project(name, code);
        project.setManager(employeeDao.find(managerId));
        List<Employee> pes=new ArrayList<>();
        for(int peId: peIds)
            pes.add(employeeDao.find(peId));
        project.setPes(pes);
        return projectDao.save(project);
    }

    public void updateProject(Project project){ projectDao.update(project);}
}
