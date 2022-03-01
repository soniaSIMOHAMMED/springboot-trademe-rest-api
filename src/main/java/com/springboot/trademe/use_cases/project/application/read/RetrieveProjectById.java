package com.springboot.trademe.use_cases.project.application.read;

import com.springboot.trademe.kernel.Query;

public class RetrieveProjectById implements Query {

    public final Long id;

    public RetrieveProjectById(Long id) {
        this.id = id;
    }
}
