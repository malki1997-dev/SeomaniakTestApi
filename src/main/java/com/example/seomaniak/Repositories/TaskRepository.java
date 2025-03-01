package com.example.seomaniak.Repositories;

import com.example.seomaniak.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{
    List<Task> findAllByProject_Id(Long projectId);

    List<Task> findByStatus(String status);

    List<Task> findByTitle(String title);
}
