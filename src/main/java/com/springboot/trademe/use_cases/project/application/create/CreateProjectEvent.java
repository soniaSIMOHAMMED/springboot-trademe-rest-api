package com.springboot.trademe.use_cases.project.application.create;

import com.springboot.trademe.kernel.ApplicationEvent;

public class CreateProjectEvent implements ApplicationEvent {

    private final Long projectId;

    public CreateProjectEvent(Long projectId) {
        this.projectId = projectId;
    }

    public static CreateProjectEvent of(Long projectId){
        return new CreateProjectEvent(projectId);
    }
}
