package com.springboot.trademe.use_cases.payment.domain;

import com.springboot.trademe.use_cases.user.domain.Contractor;
import com.springboot.trademe.use_cases.user.domain.Tradesman;
import com.springboot.trademe.use_cases.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long paymentId;

    private Double amount;

/*    @OneToOne(mappedBy = "userId")
    private User user;*/



}
