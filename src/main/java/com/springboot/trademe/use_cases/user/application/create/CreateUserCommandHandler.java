package com.springboot.trademe.use_cases.user.application.create;

import com.springboot.trademe.kernel.CommandHandler;
import com.springboot.trademe.kernel.Event;
import com.springboot.trademe.kernel.EventDispatcher;
import com.springboot.trademe.use_cases.user.domain.User;
import com.springboot.trademe.use_cases.user.domain.UserRepository;

public class CreateUserCommandHandler implements CommandHandler<CreateUser, Long> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateUserCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }


    @Override
    public Long handle(CreateUser createUser) {
        final Long userId = userRepository.count() + 1;
        User user = new User(userId, createUser.lastname, createUser.firstname, createUser.age, createUser.city, createUser.phoneNumber,createUser.email,createUser.password,createUser.trade);
        userRepository.save(user);
        eventEventDispatcher.dispatch(new CreateUserEvent(userId));
        return userId;
    }
}
