package com.example.seomaniak.Services;

import com.example.seomaniak.Models.Project;
import com.example.seomaniak.Models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService
{

    List<Project> findAll();

    Project findById(Long id);

    Project save(Project project);

    Project update(Project project);

    Project deleteById(Long id);

    List<Task> findAllTaskByProjectId(Long projectId);

}
