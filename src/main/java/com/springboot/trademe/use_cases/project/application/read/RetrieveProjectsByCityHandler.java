package com.springboot.trademe.use_cases.project.application.read;

import com.springboot.trademe.kernel.QueryHandler;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;

import java.util.List;

public class RetrieveProjectsByCityHandler implements QueryHandler<RetrieveProjectsByCity, List<Project>> {

    private final ProjectRepository projectRepository;

    public RetrieveProjectsByCityHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> handle(RetrieveProjectsByCity query) {
        return projectRepository.findByCity(query.city);
    }
}
