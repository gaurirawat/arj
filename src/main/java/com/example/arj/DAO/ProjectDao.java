package com.example.arj.DAO;

import com.example.arj.models.Project;
import com.example.arj.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public void delete(Project project) {
        projectRepository.deleteById(project.getId());
    }

    @Override
    public void delete(Integer id) {
        projectRepository.deleteById(id);
    }
}
