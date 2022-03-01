package com.springboot.trademe.use_cases.user.application.delete;

import com.springboot.trademe.kernel.CommandHandler;
import com.springboot.trademe.kernel.Event;
import com.springboot.trademe.kernel.EventDispatcher;
import com.springboot.trademe.kernel.exception.ResourceNotFoundException;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;
import com.springboot.trademe.use_cases.user.domain.User;
import com.springboot.trademe.use_cases.user.domain.UserRepository;

public class DeleteUserCommandHandler implements CommandHandler<DeleteUser, Boolean> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public DeleteUserCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Boolean handle(DeleteUser deleteUser) {
        User user = this.userRepository.findById(deleteUser.id).orElseThrow(() -> new ResourceNotFoundException("User","id", deleteUser.id));
        this.userRepository.delete(user);
        eventEventDispatcher.dispatch(new DeleteUserEvent(deleteUser.id));
        return !this.userRepository.existsById(deleteUser.id);
    }



}
