package com.springboot.trademe.use_cases.project.exposition;


import lombok.Data;

@Data
public class ProjectDTO {

    public Long projectId;
    public String  city;
    public int dailyRate;
    public int periodOfEngagement;
    public String requiredSkills;
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
