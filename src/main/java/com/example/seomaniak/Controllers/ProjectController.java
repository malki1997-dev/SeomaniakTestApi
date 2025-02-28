package com.example.seomaniak.Controllers;

import com.example.seomaniak.Models.Project;
import com.example.seomaniak.Services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/projects")
public class ProjectController
{
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAll()
    {
        List<Project> projects = projectService.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> Add(@RequestBody Project project)
    {
        return new ResponseEntity<>(projectService.save(project), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Project> Delete(@PathVariable Long id)
    {
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<Project> Update(@PathVariable Long id, @RequestBody Project project)
    {
        project.setId(id);
        Project updatedProject = projectService.update(project);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }


}
