package com.springboot.trademe.use_cases.user.application.read;

import com.springboot.trademe.kernel.Query;

public class RetrieveUserById implements Query {

    public final Long id;

    public RetrieveUserById(Long id) {
        this.id = id;
    }
}
