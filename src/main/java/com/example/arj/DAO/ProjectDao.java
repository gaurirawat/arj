package com.example.arj.DAO;

import com.example.arj.Models.Project;
import com.example.arj.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectDao implements Dao<Project> {

    @Autowired
    ProjectRepository projectRepository;

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
        return projectRepository.save(project);
    }

}
