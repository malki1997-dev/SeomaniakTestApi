package com.example.seomaniak.Services;


import com.example.seomaniak.Models.Task;

import java.util.List;

public interface TaskService
{

    List<Task> findByStatus(String status);

    List<Task> findByTitle(String title);

}
