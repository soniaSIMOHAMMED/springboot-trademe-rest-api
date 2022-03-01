package com.springboot.trademe.use_cases.user.application.update;

import com.springboot.trademe.kernel.ApplicationEvent;

public class UpdateUserEvent implements ApplicationEvent {
    private final Long userId;

    public UpdateUserEvent(Long userId) {
        this.userId = userId;
    }
}
