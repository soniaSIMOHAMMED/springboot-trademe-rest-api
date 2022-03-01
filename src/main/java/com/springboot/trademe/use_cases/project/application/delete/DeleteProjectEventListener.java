package com.springboot.trademe.use_cases.project.application.delete;

import com.springboot.trademe.kernel.EventListener;

public class DeleteProjectEventListener implements EventListener<DeleteProjectEvent> {


    @Override
    public void listenTo(DeleteProjectEvent event) {
        System.out.println("listening to DeleteProjectEvent.");
    }
}
