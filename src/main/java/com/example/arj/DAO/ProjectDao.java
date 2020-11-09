package com.example.arj.DAO;

import com.example.arj.Models.Employee;
import com.example.arj.Models.Project;
import com.example.arj.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectDao implements Dao<Project> {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeDao employeeDao;
    @Override
    public Project find(Integer id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project project) {
        Project dbProject=projectRepository.getOne(project.getId());
        dbProject.setName(project.getName());
        dbProject.setCode(project.getCode());
        dbProject.setManager(employeeDao.find(project.getManager().getId()));
        List<Employee> pes= new ArrayList<Employee>();
        for(Employee pe: project.getPes())
            pes.add(employeeDao.find(pe.getId()));
        dbProject.setPes(pes);
        return projectRepository.save(dbProject);
    }

}
