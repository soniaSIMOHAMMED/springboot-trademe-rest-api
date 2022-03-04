package com.springboot.trademe.use_cases.payment.application;

import com.springboot.trademe.kernel.CommandHandler;
import com.springboot.trademe.kernel.Event;
import com.springboot.trademe.kernel.EventDispatcher;
import com.springboot.trademe.use_cases.payment.domain.CreditCardPayment;
import com.springboot.trademe.use_cases.payment.domain.PayPalPayment;
import com.springboot.trademe.use_cases.payment.domain.Payment;
import com.springboot.trademe.use_cases.user.domain.User;
import com.springboot.trademe.use_cases.user.domain.UserRepository;

import java.time.LocalDate;
import java.util.List;

public final class PaymentPerMonthProcessCommandHandler implements CommandHandler<PaymentPerMonthProcess, Void> {
    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public PaymentPerMonthProcessCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(PaymentPerMonthProcess paymentPerMonthProcess) {
        List<User> users = userRepository.findByTradeAndCreatedDate("Contractor",LocalDate.now().getDayOfMonth());
        for(User user : users) {
            if(user.getPaymentMethod().equals("CreditCard")){
                Payment payment = new CreditCardPayment(user.getLastname(),paymentPerMonthProcess.getCreditCardPayment().getCardNumber(),
                        paymentPerMonthProcess.getCreditCardPayment().getCvv(),paymentPerMonthProcess.getCreditCardPayment().getExpiryDate());
            }
            if(user.getPaymentMethod().equals("PayPal")){
                Payment payment = new PayPalPayment(paymentPerMonthProcess.getPayPalPayment().getEmail(),paymentPerMonthProcess.getPayPalPayment().getPassword());
            }
            eventEventDispatcher.dispatch((Event) new PaymentPerMonthProcessEvent(user.getUserId()));
        }
        return null;
    }
}
