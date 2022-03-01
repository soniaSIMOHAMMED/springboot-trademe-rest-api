package com.springboot.trademe.use_cases.user.application.delete;

import com.springboot.trademe.kernel.EventListener;

public class DeleteUserEventListener implements EventListener<DeleteUserEvent> {


    @Override
    public void listenTo(DeleteUserEvent event) {
        System.out.println("listening to DeleteUserEvent.");
    }
}
