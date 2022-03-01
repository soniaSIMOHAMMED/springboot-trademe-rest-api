package com.springboot.trademe.use_cases.user.application.delete;

import com.springboot.trademe.kernel.ApplicationEvent;

public class DeleteUserEvent implements ApplicationEvent {

    private final Long userId;

    public DeleteUserEvent(Long userId) {
        this.userId = userId;
    }

}
