package com.springboot.trademe.use_cases.user.application.update;

import com.springboot.trademe.kernel.CommandHandler;
import com.springboot.trademe.kernel.Event;
import com.springboot.trademe.kernel.EventDispatcher;
import com.springboot.trademe.kernel.exception.ResourceNotFoundException;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;
import com.springboot.trademe.use_cases.user.domain.User;
import com.springboot.trademe.use_cases.user.domain.UserRepository;

public class UpdateUserCommandHandler implements CommandHandler<UpdateUser,Long> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public UpdateUserCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Long handle(UpdateUser updateUser) {

        User user = this.userRepository.findById(updateUser.id).orElseThrow(() -> new ResourceNotFoundException("User","id", updateUser.id));

        user.setLastname(updateUser.getLastname());
        user.setFirstname(updateUser.getFirstname());
        user.setAge(updateUser.getAge());
        user.setCity(updateUser.getCity());
        user.setPhoneNumber(updateUser.getPhoneNumber());
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        user.setTrade(updateUser.getTrade());
        user.setPaymentMethod(updateUser.getPaymentMethod());

        User updatedUser = userRepository.save(user);

        return updateUser.id;
    }



}
