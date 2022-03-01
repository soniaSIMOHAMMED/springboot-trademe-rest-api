package com.springboot.trademe.use_cases.project.application.update;

import com.springboot.trademe.kernel.Command;
import lombok.Getter;

@Getter
public class UpdateProject implements Command {

    public Long id;
    public String  city;
    public int dailyRate;
    public int periodOfEngagement;
    public String requiredSkills;
    public String requiredTrades;


    public UpdateProject(Long id, String city, int dailyRate, int periodOfEngagement, String requiredSkills, String requiredTrades) {
        this.id = id;
        this.city = city;
        this.dailyRate = dailyRate;
        this.periodOfEngagement = periodOfEngagement;
        this.requiredSkills = requiredSkills;
        this.requiredTrades = requiredTrades;
    }

}
