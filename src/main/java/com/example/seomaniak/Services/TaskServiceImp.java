package com.example.seomaniak.Services;

import com.example.seomaniak.Models.Task;
import com.example.seomaniak.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService
{

    @Autowired
    private TaskRepository taskRepository;

    public TaskServiceImp(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }
}
