package com.springboot.trademe.use_cases.payment.exposition;

import lombok.Getter;

@Getter
public class PaymentDTO {

    public Long paymentId;

    public PaymentDTO(Long paymentId) {
        this.paymentId = paymentId;
    }
}
