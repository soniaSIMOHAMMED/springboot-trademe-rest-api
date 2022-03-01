package com.springboot.trademe.use_cases.project.application.delete;

import com.springboot.trademe.kernel.CommandHandler;
import com.springboot.trademe.kernel.Event;
import com.springboot.trademe.kernel.EventDispatcher;
import com.springboot.trademe.kernel.exception.ResourceNotFoundException;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;

public class DeleteProjectCommandHandler implements CommandHandler<DeleteProject, Boolean> {

    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public DeleteProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Boolean handle(DeleteProject deleteProject) {
        Project project = this.projectRepository.findById(deleteProject.id).orElseThrow(() -> new ResourceNotFoundException("Project","id", deleteProject.id));
        this.projectRepository.delete(project);
        eventEventDispatcher.dispatch(new DeleteProjectEvent(deleteProject.id));
        return !this.projectRepository.existsById(deleteProject.id);
    }





/*    @Override
    public Void handle(DeleteProject deleteProject) {
        Project project = this.projectRepository.findById(deleteProject.id).orElseThrow(() -> new ResourceNotFoundException("Project","id", deleteProject.id));
        this.projectRepository.delete(project);
        eventEventDispatcher.dispatch(new DeleteProjectEvent(deleteProject.id));    }*/
}
