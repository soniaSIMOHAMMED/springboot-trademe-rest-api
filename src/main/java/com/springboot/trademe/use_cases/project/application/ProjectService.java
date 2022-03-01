package com.springboot.trademe.use_cases.project.application;

import com.springboot.trademe.use_cases.project.exposition.ProjectDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);
    List<ProjectDTO> getAllProjects();
    ProjectDTO getProjectById(long id);
    ProjectDTO updateProject(ProjectDTO projectDTO, long id);
    void deleteProject(long id);


}
