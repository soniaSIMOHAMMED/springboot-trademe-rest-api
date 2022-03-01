package com.springboot.trademe.use_cases.user.application.delete;

import com.springboot.trademe.kernel.Command;

public class DeleteUser implements Command {

    public final Long id;

    public DeleteUser(Long id) {
        this.id = id;
    }





}
