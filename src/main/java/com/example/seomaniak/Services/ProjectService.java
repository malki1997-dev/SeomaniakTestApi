package com.example.seomaniak.Services;

import com.example.seomaniak.Models.Project;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService
{

    List<Project> findAll();

    Project findById(Long id);

    Project save(Project project);

    Project update(Project project);

    Project deleteById(Long id);



}
