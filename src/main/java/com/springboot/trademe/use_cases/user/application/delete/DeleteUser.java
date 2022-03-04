package com.springboot.trademe.use_cases.user.application.delete;

import com.springboot.trademe.kernel.Command;

public class DeleteUser implements Command {

    public final long id;

    public DeleteUser(long id) {
        this.id = id;
    }

}
