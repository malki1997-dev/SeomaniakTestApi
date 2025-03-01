package com.example.seomaniak.Repositories;

import com.example.seomaniak.Models.Project;
import com.example.seomaniak.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>
{

}
