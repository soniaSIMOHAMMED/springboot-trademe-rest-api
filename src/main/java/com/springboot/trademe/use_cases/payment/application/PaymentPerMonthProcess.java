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

    public Double amount = 25.00;
    public Long userId;
    public String name;
    public String cardNumber;
    public String cvv;
    public String expiryDate;
    public String email;

    public String password;


    public PaymentPerMonthProcess(Long userId, String name, String cardNumber, String cvv, String expiryDate) {
        this.userId = userId;
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public PaymentPerMonthProcess(Long userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public static PaymentPerMonthProcess of(Long userId, String name, String cardNumber, String cvv, String expiryDate){
        return new PaymentPerMonthProcess(userId, name,cardNumber,cvv,expiryDate);
    }

    public static PaymentPerMonthProcess of(Long userId,String email, String password){
        return new PaymentPerMonthProcess(userId,email,password);
    }






}
