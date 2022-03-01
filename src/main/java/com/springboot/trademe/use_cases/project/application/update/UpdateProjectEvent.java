package com.springboot.trademe.use_cases.project.application.update;

import com.springboot.trademe.kernel.ApplicationEvent;

public class UpdateProjectEvent implements ApplicationEvent {
    private final Long projectId;

    public UpdateProjectEvent(Long projectId) {
        this.projectId = projectId;
    }
}
