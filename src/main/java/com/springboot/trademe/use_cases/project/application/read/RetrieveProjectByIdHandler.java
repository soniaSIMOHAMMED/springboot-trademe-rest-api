package com.springboot.trademe.use_cases.project.application.read;

import com.springboot.trademe.kernel.QueryHandler;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;

public class RetrieveProjectByIdHandler implements QueryHandler<RetrieveProjectById, Project> {

    private final ProjectRepository projectRepository;

    public RetrieveProjectByIdHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project handle(RetrieveProjectById query) {
        return projectRepository.getById(query.id);
    }
}
