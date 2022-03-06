package com.springboot.trademe.use_cases.payment.application;

import com.springboot.trademe.kernel.CommandHandler;
import com.springboot.trademe.kernel.Event;
import com.springboot.trademe.kernel.EventDispatcher;
import com.springboot.trademe.use_cases.payment.domain.CreditCardPayment;
import com.springboot.trademe.use_cases.payment.domain.PayPalPayment;
import com.springboot.trademe.use_cases.payment.domain.Payment;
import com.springboot.trademe.use_cases.payment.domain.PaymentRepository;
import com.springboot.trademe.use_cases.user.domain.User;
import com.springboot.trademe.use_cases.user.domain.UserRepository;
import com.springboot.trademe.use_cases.user.exposition.UserDTO;

import java.util.Optional;

public final class PaymentPerMonthProcessCommandHandler implements CommandHandler<PaymentPerMonthProcess, Void> {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public PaymentPerMonthProcessCommandHandler(PaymentRepository paymentRepository, UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.paymentRepository = paymentRepository;

        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public static PaymentPerMonthProcessCommandHandler of(PaymentRepository paymentRepository, UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher){
        return new PaymentPerMonthProcessCommandHandler(paymentRepository, userRepository, eventEventDispatcher);
    }


    @Override
    public Void handle(PaymentPerMonthProcess paymentPerMonthProcess) {
/*        List<User> users = userRepository.findByTradeAndCreatedDate("Tradesman",LocalDate.now().getDayOfMonth());
        for(User user : users) {
            if(user.getPaymentMethod().equals("CreditCard")){
                Payment payment = new CreditCardPayment(user.getLastname(),paymentPerMonthProcess.getCardNumber(),
                        paymentPerMonthProcess.getCvv(),paymentPerMonthProcess.getExpiryDate());
            }
            if(user.getPaymentMethod().equals("PayPal")){
                Payment payment = new PayPalPayment(paymentPerMonthProcess.getEmail(),paymentPerMonthProcess.getPassword());
            }
            eventEventDispatcher.dispatch((Event) new PaymentPerMonthProcessEvent(user.getUserId()));
        }*/
        final Long paymentId = paymentRepository.count() + 1;
        Optional<User> user = userRepository.findById(paymentPerMonthProcess.userId);
        Payment payment;
        if(user.isPresent() ? user.get().getPaymentMethod().equals("creditCard") : null) { payment = new CreditCardPayment(paymentPerMonthProcess.name, paymentPerMonthProcess.cardNumber, paymentPerMonthProcess.cvv, paymentPerMonthProcess.expiryDate);}
        else{ payment = new PayPalPayment(paymentPerMonthProcess.email, paymentPerMonthProcess.password);}
        paymentRepository.save(payment);
        eventEventDispatcher.dispatch(new PaymentPerMonthProcessEvent(paymentId));
        return null;
    }




}
