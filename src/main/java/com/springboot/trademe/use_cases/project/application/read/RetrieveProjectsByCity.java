package com.springboot.trademe.use_cases.project.application.read;

import com.springboot.trademe.kernel.Query;

public class RetrieveProjectsByCity implements Query {
    public final String city;

    public RetrieveProjectsByCity(String city) {
        this.city = city;
    }
}
