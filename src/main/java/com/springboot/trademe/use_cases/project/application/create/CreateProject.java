package com.springboot.trademe.use_cases.project.application.create;

import com.springboot.trademe.kernel.Command;
import lombok.AllArgsConstructor;

public final class CreateProject implements Command {

    public String  address;
    public int dailyRate;
    public int periodOfEngagement;
    public String requiredSkills;
    public String requiredTrades;


    public CreateProject(String address, int dailyRate, int periodOfEngagement, String requiredSkills, String requiredTrades) {
        this.address = address;
        this.dailyRate = dailyRate;
        this.periodOfEngagement = periodOfEngagement;
        this.requiredSkills = requiredSkills;
        this.requiredTrades = requiredTrades;
    }

    public static CreateProject of(String address, int dailyRate, int periodOfEngagement, String requiredSkills, String requiredTrades){
        return new CreateProject(address,dailyRate,periodOfEngagement,requiredSkills,requiredTrades);
    }

}
