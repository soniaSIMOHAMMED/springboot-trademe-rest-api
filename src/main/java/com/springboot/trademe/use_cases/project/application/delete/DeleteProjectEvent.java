package com.springboot.trademe.use_cases.project.application.delete;

import com.springboot.trademe.kernel.ApplicationEvent;

public class DeleteProjectEvent implements ApplicationEvent {

    private final Long projectId;

    public DeleteProjectEvent(Long projectId) {
        this.projectId = projectId;
    }

}
