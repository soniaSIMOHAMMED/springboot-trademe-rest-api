package com.springboot.trademe.use_cases.user.application.read;

import com.springboot.trademe.kernel.QueryHandler;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;
import com.springboot.trademe.use_cases.user.domain.User;
import com.springboot.trademe.use_cases.user.domain.UserRepository;

public class RetrieveUserByIdHandler implements QueryHandler<RetrieveUserById, User> {

    private final UserRepository userRepository;

    public RetrieveUserByIdHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(RetrieveUserById query) {
        return userRepository.getById(query.id);
    }
}
