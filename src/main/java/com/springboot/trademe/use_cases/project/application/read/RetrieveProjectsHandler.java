package com.springboot.trademe.use_cases.project.application.read;

import com.springboot.trademe.kernel.QueryHandler;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;

import java.util.List;

public class RetrieveProjectsHandler implements QueryHandler<RetrieveProjects, List<Project>> {

    private final ProjectRepository projectRepository;

    public RetrieveProjectsHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> handle(RetrieveProjects query) {
        return projectRepository.findAll();
    }
}
