package com.springboot.trademe.use_cases.user.application.create;

import com.springboot.trademe.kernel.EventListener;

public class CreateUserEventListener implements EventListener<CreateUserEvent> {

    @Override
    public void listenTo(CreateUserEvent event) {
        System.out.println("listening to CreateUserEvent.");
    }

}
