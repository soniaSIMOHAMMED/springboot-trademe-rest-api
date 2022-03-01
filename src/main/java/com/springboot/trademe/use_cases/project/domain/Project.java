package com.springboot.trademe.use_cases.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "projects"
)
public class Project {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long projectId;

    @Column(name = "city", nullable = false)
    private String  city;

    @Column(name = "daily rate", nullable = false)
    private int dailyRate;

    @Column(name = "period of engagement", nullable = false)
    private int periodOfEngagement;

    @Column(name = "requeried skills", nullable = false)
    private String requiredSkills;

    @Column(name = "required trades", nullable = false)
    private String requiredTrades;


}
