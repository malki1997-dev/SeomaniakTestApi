package com.example.seomaniak.Services;

import com.example.seomaniak.Models.Project;
import com.example.seomaniak.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImp implements ProjectService
{
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }


    @Override
    public List<Project> findAll() {
        List<Project> projects = projectRepository.findAll();
        return projects;
    }

    @Override
    public Project findById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.orElse(null);
    }

    @Override
    public Project save(Project project) {
        Project savedProject = projectRepository.save(project);
        return savedProject;
    }

    @Override
    public Project update(Project project) {
        Project savedProject = projectRepository.findById(project.getId()).get();
        savedProject.setName(project.getName());
        savedProject.setDescription(project.getDescription());
        savedProject.setStartDate(project.getStartDate());
        savedProject.setEndDate(project.getEndDate());
        projectRepository.save(savedProject);
        return savedProject;

    }

    @Override
    public Project deleteById(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        projectRepository.delete(project);
        return project;
    }
}
