package com.springboot.trademe.use_cases.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "creditCard", uniqueConstraints = @UniqueConstraint(columnNames = {"cardNumber","name}"}))
public class CreditCardPayment extends Payment{

    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

}
