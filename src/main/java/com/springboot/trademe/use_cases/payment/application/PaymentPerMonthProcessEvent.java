package com.springboot.trademe.use_cases.payment.application;

import com.springboot.trademe.kernel.ApplicationEvent;

public final class PaymentPerMonthProcessEvent implements ApplicationEvent {
    private final Long userId;

    public PaymentPerMonthProcessEvent(Long userId) {
        this.userId = userId;
    }

}
