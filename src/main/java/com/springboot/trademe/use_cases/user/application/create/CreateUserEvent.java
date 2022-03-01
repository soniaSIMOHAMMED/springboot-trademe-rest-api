package com.springboot.trademe.use_cases.user.application.create;

import com.springboot.trademe.kernel.ApplicationEvent;

public class CreateUserEvent implements ApplicationEvent {
    private final Long userId;

    public CreateUserEvent(Long userId) {
        this.userId = userId;
    }
}
