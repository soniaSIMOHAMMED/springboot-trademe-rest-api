package com.springboot.trademe.use_cases.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "paypal", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class PayPalPayment extends Payment{

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}
