package com.example.seomaniak.Controllers;


import com.example.seomaniak.Models.Task;
import com.example.seomaniak.Services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/tasks")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @GetMapping("status/{status}")
    public ResponseEntity<List<Task>> getAllTasksByStatus(@PathVariable String status)
    {
        List<Task> tasks = taskService.findByStatus(status);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("title/{title}")
    public ResponseEntity<List<Task>> getAllTasksByTitle(@PathVariable String title)
    {
        List<Task> tasks = taskService.findByTitle(title);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
