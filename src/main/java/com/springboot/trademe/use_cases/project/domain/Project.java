package com.springboot.trademe.use_cases.project.domain;

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

    @Column(name = "daily_rate", nullable = false)
    private int dailyRate;

    @Column(name = "period_of_engagement", nullable = false)
    private int periodOfEngagement;

    @Column(name = "requeried_skills", nullable = false)
    private String requiredSkills;

    @Column(name = "required_trades", nullable = false)
    private String requiredTrades;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;*/


}
