package com.springboot.trademe.use_cases.project.application.update;

import com.springboot.trademe.kernel.EventListener;

public class UpdateProjectEventListner implements EventListener<UpdateProjectEvent> {

    @Override
    public void listenTo(UpdateProjectEvent event) {
        System.out.println("listening to UpdateProjectEvent.");

    }
}
