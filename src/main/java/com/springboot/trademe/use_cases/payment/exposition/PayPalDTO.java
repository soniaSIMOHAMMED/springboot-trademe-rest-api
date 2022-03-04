package com.springboot.trademe.use_cases.payment.exposition;

import lombok.Getter;

@Getter
public class PayPalDTO {

    private String email;
    private String password;

    public PayPalDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
