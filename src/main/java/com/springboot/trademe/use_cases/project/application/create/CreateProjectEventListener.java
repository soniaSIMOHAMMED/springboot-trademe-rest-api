package com.springboot.trademe.use_cases.project.application.create;

import com.springboot.trademe.kernel.EventListener;

public class CreateProjectEventListener implements EventListener<CreateProjectEvent> {

    @Override
    public void listenTo(CreateProjectEvent event) {
        System.out.println("listening to CreateProjectEvent.");
    }

}
