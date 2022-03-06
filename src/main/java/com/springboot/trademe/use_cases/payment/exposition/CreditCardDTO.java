package com.springboot.trademe.use_cases.payment.exposition;

import com.springboot.trademe.use_cases.payment.domain.Payment;
import lombok.Getter;

@Getter
public class CreditCardDTO {

    public String name;
    public String cardNumber;
    public String cvv;
    public String expiryDate;

    public CreditCardDTO(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
}
