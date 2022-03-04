package com.springboot.trademe.use_cases.user.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.trademe.use_cases.payment.domain.Payment;
import com.springboot.trademe.use_cases.project.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


/*@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tradesman")*/

public class Tradesman extends User {
/*
    private String trade;

    @ElementCollection
    private List<String> skills;

    @ElementCollection
    private List<String> disponibility;

    private int dailyRate;

    private boolean paymentPerMonth;*/


/*    @JsonIgnore
    @OneToMany(mappedBy = "tradesman", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Project> projects;*/

}
