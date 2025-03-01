package com.example.seomaniak.Services;

import com.example.seomaniak.Models.Project;
import com.example.seomaniak.Models.Task;
import com.example.seomaniak.Repositories.ProjectRepository;
import com.example.seomaniak.Repositories.TaskRepository;
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
    @Autowired
    private TaskRepository taskRepository;


    public ProjectServiceImp(ProjectRepository projectRepository, TaskRepository taskRepository)
    {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
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

    @Override
    public List<Task> findAllTaskByProjectId(Long projectId) {

        return taskRepository.findAllByProject_Id(projectId);

    }
}
