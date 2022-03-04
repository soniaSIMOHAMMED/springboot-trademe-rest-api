package com.springboot.trademe;

import com.springboot.trademe.kernel.*;
import com.springboot.trademe.use_cases.user.application.create.CreateUser;
import com.springboot.trademe.use_cases.user.application.create.CreateUserCommandHandler;
import com.springboot.trademe.use_cases.user.application.create.CreateUserEvent;
import com.springboot.trademe.use_cases.user.application.create.CreateUserEventListener;
import com.springboot.trademe.use_cases.user.application.delete.DeleteUser;
import com.springboot.trademe.use_cases.user.application.delete.DeleteUserCommandHandler;
import com.springboot.trademe.use_cases.user.application.delete.DeleteUserEvent;
import com.springboot.trademe.use_cases.user.application.delete.DeleteUserEventListener;
import com.springboot.trademe.use_cases.user.application.read.*;
import com.springboot.trademe.use_cases.user.domain.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ApplicationConfig {

    UserRepository userRepository;

    public ApplicationConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }


    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(DeleteUserEvent.class, List.of(new DeleteUserEventListener()));
        listenerMap.put(CreateUserEvent.class, List.of(new CreateUserEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateUserCommandHandler createUserCommandHandler() {
        return new CreateUserCommandHandler(userRepository, eventEventDispatcher());
    }

    @Bean
    public DeleteUserCommandHandler deleteUserCommandHandler() {
        return new DeleteUserCommandHandler(userRepository, eventEventDispatcher());
    }


    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateUser.class, new CreateUserCommandHandler(userRepository, eventEventDispatcher()));
        commandHandlerMap.put(DeleteUser.class, new DeleteUserCommandHandler(userRepository, eventEventDispatcher()));
        return new DefaultCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();
        queryHandlerMap.put(RetrieveUsersByCity.class, new RetrieveUsersByCityHandler(userRepository));
        queryHandlerMap.put(RetrieveUsers.class, new RetrieveUsersHandler(userRepository));
        queryHandlerMap.put(RetrieveUserById.class, new RetrieveUserByIdHandler(userRepository));
        return new DefaultQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveUsersHandler retrieveUsersHandler() {
        return new RetrieveUsersHandler(userRepository);
    }

    @Bean
    public RetrieveUsersByCityHandler retrieveUsersByCityHandler() {
        return new RetrieveUsersByCityHandler(userRepository);
    }

    @Bean
    public RetrieveUserByIdHandler retrieveUserByIdHandler() {
        return new RetrieveUserByIdHandler(userRepository);
    }

}
