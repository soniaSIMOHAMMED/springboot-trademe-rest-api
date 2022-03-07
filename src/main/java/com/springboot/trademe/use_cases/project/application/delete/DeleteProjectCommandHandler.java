package com.springboot.trademe.use_cases.project.application.delete;

import com.springboot.trademe.kernel.CommandHandler;
import com.springboot.trademe.kernel.Event;
import com.springboot.trademe.kernel.EventDispatcher;
import com.springboot.trademe.kernel.exception.ResourceNotFoundException;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteProjectCommandHandler implements CommandHandler<DeleteProject, Void> {

    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public DeleteProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(DeleteProject deleteProject) {
        Project project = this.projectRepository.findById(deleteProject.id).orElseThrow(() -> ResourceNotFoundException.of("Project","id", deleteProject.id));
        this.projectRepository.delete(project);
        eventEventDispatcher.dispatch(new DeleteProjectEvent(deleteProject.id));
        return null;
    }
    
}
