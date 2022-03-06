package com.springboot.trademe.use_cases.project.application.create;

import com.springboot.trademe.kernel.EventListener;

public final class CreateProjectEventListener implements EventListener<CreateProjectEvent> {

    public static CreateProjectEventListener of(){
        return new CreateProjectEventListener();
    }

    @Override
    public void listenTo(CreateProjectEvent event) {
        System.out.println("listening to CreateProjectEvent.");
    }

}
