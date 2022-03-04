package com.springboot.trademe.use_cases.payment.application;

import com.springboot.trademe.kernel.Command;
import com.springboot.trademe.use_cases.payment.domain.CreditCardPayment;
import com.springboot.trademe.use_cases.payment.domain.PayPalPayment;
import com.springboot.trademe.use_cases.payment.domain.Payment;
import com.springboot.trademe.use_cases.payment.exposition.PayPalDTO;
import com.springboot.trademe.use_cases.user.domain.Tradesman;
import com.springboot.trademe.use_cases.user.domain.User;
import lombok.Getter;

@Getter
public final class PaymentPerMonthProcess implements Command {

    public Long id;
    public Double amount = 25.00;
    public CreditCardPayment creditCardPayment;
    public PayPalPayment payPalPayment;



    public PaymentPerMonthProcess(Long id, CreditCardPayment creditCardPayment){
        this.id = id;
        this.creditCardPayment = creditCardPayment;

    }

    public PaymentPerMonthProcess(Long id, PayPalPayment payPalPayment){
        this.id = id;
        this.payPalPayment = payPalPayment;
    }




}
