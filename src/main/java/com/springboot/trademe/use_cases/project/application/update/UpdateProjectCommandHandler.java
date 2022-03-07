package com.springboot.trademe.use_cases.project.application.update;

import com.springboot.trademe.kernel.CommandHandler;
import com.springboot.trademe.kernel.Event;
import com.springboot.trademe.kernel.EventDispatcher;
import com.springboot.trademe.kernel.exception.ResourceNotFoundException;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;

public class UpdateProjectCommandHandler implements CommandHandler<UpdateProject,Void> {

    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public UpdateProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(UpdateProject updateProject) {

        Project project = this.projectRepository.findById(updateProject.id).orElseThrow(() -> ResourceNotFoundException.of("Project","id", updateProject.id));

        project.setCity(updateProject.getCity());
        project.setDailyRate(updateProject.getDailyRate());
        project.setPeriodOfEngagement(updateProject.getPeriodOfEngagement());
        project.setRequiredSkills(updateProject.getRequiredSkills());
        project.setRequiredTrades(updateProject.getRequiredTrades());
        Project updatedProject = projectRepository.save(project);

        return null;
    }



}
