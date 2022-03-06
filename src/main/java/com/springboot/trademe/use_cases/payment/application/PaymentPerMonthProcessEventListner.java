package com.springboot.trademe.use_cases.payment.application;

import com.springboot.trademe.kernel.EventListener;
import com.springboot.trademe.use_cases.user.application.create.CreateUserEvent;

public final class PaymentPerMonthProcessEventListner implements EventListener<CreateUserEvent> {

    @Override
    public void listenTo(CreateUserEvent event) {
        System.out.println("listening to PayPerMonthEvent.");
    }

}
