package com.springboot.trademe.use_cases.user.exposition;

import com.springboot.trademe.use_cases.project.exposition.ProjectDTO;

import java.util.List;

public class UsersDTO {

    public final List<UserDTO> users;

    public UsersDTO(List<UserDTO> users) {
        this.users = users;
    }



}
