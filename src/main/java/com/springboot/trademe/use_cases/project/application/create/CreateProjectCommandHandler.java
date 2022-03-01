package com.springboot.trademe.use_cases.project.application.create;

import com.springboot.trademe.kernel.CommandHandler;
import com.springboot.trademe.kernel.Event;
import com.springboot.trademe.kernel.EventDispatcher;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;

public class CreateProjectCommandHandler implements CommandHandler<CreateProject, Long> {

    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }


    @Override
    public Long handle(CreateProject createProject) {
        final Long projectId = projectRepository.count() + 1;
        Project project = new Project(projectId,createProject.address, createProject.dailyRate, createProject.periodOfEngagement, createProject.requiredSkills, createProject.requiredTrades);
        projectRepository.save(project);
        eventEventDispatcher.dispatch(new CreateProjectEvent(projectId));
        return projectId;
    }
}
