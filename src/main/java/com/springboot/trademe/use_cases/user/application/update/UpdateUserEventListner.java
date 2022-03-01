package com.springboot.trademe.use_cases.user.application.update;

import com.springboot.trademe.kernel.EventListener;

public class UpdateUserEventListner implements EventListener<UpdateUserEvent> {

    @Override
    public void listenTo(UpdateUserEvent event) {
        System.out.println("listening to UpdateProjectEvent.");

    }
}
