package com.springboot.trademe.use_cases.user.application.read;

import com.springboot.trademe.kernel.Query;

public class RetrieveUsersByCity implements Query {
    public final String city;

    public RetrieveUsersByCity(String city) {
        this.city = city;
    }
}
