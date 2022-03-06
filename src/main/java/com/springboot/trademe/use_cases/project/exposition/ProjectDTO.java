package com.springboot.trademe.use_cases.project.exposition;


import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class ProjectDTO {

    public Long projectId;

    @NotEmpty(message = "city should not be null or empty")
    public String city;

    public int dailyRate;

    public int periodOfEngagement;

    @NotEmpty(message = "requiredSkills should not be null or empty")
    public String requiredSkills;

    @NotEmpty(message = "requiredTrades should not be null or empty")
    public String requiredTrades;


    public ProjectDTO(Long projectId, String city, int dailyRate, int periodOfEngagement, String requiredSkills, String requiredTrades) {
        this.projectId = projectId;
        this.city = city;
        this.dailyRate = dailyRate;
        this.periodOfEngagement = periodOfEngagement;
        this.requiredSkills = requiredSkills;
        this.requiredTrades = requiredTrades;
    }
}
