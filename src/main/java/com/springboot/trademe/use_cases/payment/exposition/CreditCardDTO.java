package com.springboot.trademe.use_cases.payment.exposition;

import lombok.Getter;

@Getter
public class CreditCardDTO {

    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardDTO(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
}
