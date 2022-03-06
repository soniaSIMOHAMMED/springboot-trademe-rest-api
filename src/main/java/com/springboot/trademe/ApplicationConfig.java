package com.springboot.trademe;

import com.springboot.trademe.kernel.*;
import com.springboot.trademe.use_cases.project.application.create.CreateProject;
import com.springboot.trademe.use_cases.project.application.create.CreateProjectCommandHandler;
import com.springboot.trademe.use_cases.project.application.create.CreateProjectEvent;
import com.springboot.trademe.use_cases.project.application.create.CreateProjectEventListener;
import com.springboot.trademe.use_cases.project.application.delete.DeleteProject;
import com.springboot.trademe.use_cases.project.application.delete.DeleteProjectCommandHandler;
import com.springboot.trademe.use_cases.project.application.delete.DeleteProjectEvent;
import com.springboot.trademe.use_cases.project.application.delete.DeleteProjectEventListener;
import com.springboot.trademe.use_cases.project.application.read.*;
import com.springboot.trademe.use_cases.project.application.update.UpdateProject;
import com.springboot.trademe.use_cases.project.application.update.UpdateProjectCommandHandler;
import com.springboot.trademe.use_cases.project.application.update.UpdateProjectEvent;
import com.springboot.trademe.use_cases.project.application.update.UpdateProjectEventListener;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;
import com.springboot.trademe.use_cases.user.application.create.CreateUser;
import com.springboot.trademe.use_cases.user.application.create.CreateUserCommandHandler;
import com.springboot.trademe.use_cases.user.application.create.CreateUserEvent;
import com.springboot.trademe.use_cases.user.application.create.CreateUserEventListener;
import com.springboot.trademe.use_cases.user.application.delete.DeleteUser;
import com.springboot.trademe.use_cases.user.application.delete.DeleteUserCommandHandler;
import com.springboot.trademe.use_cases.user.application.delete.DeleteUserEvent;
import com.springboot.trademe.use_cases.user.application.delete.DeleteUserEventListener;
import com.springboot.trademe.use_cases.user.application.read.*;
import com.springboot.trademe.use_cases.user.application.update.UpdateUser;
import com.springboot.trademe.use_cases.user.application.update.UpdateUserCommandHandler;
import com.springboot.trademe.use_cases.user.application.update.UpdateUserEvent;
import com.springboot.trademe.use_cases.user.application.update.UpdateUserEventListener;
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
    ProjectRepository projectRepository;

    public ApplicationConfig(UserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }


    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();

        listenerMap.put(CreateUserEvent.class, List.of(new CreateUserEventListener()));
        listenerMap.put(DeleteUserEvent.class, List.of(new DeleteUserEventListener()));
        listenerMap.put(UpdateUserEvent.class, List.of(new UpdateUserEventListener()));

        listenerMap.put(CreateProjectEvent.class, List.of(CreateProjectEventListener.of()));
        listenerMap.put(DeleteProjectEvent.class, List.of(new DeleteProjectEventListener()));
        listenerMap.put(UpdateProjectEvent.class, List.of(new UpdateProjectEventListener()));





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
    public UpdateUserCommandHandler updateUserCommandHandler(){
        return new UpdateUserCommandHandler(userRepository, eventEventDispatcher());
    }

    @Bean
    public CreateProjectCommandHandler createProjectCommandHandler() {
        return CreateProjectCommandHandler.of(projectRepository, eventEventDispatcher());
    }

    @Bean
    public DeleteProjectCommandHandler deleteProjectCommandHandler() {
        return new DeleteProjectCommandHandler(projectRepository, eventEventDispatcher());
    }

    @Bean
    public UpdateProjectCommandHandler updateProjectCommandHandler(){
        return new UpdateProjectCommandHandler(projectRepository, eventEventDispatcher());
    }


    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();

        commandHandlerMap.put(CreateUser.class, new CreateUserCommandHandler(userRepository, eventEventDispatcher()));
        commandHandlerMap.put(DeleteUser.class, new DeleteUserCommandHandler(userRepository, eventEventDispatcher()));
        commandHandlerMap.put(UpdateUser.class, new UpdateUserCommandHandler(userRepository, eventEventDispatcher()));

        commandHandlerMap.put(CreateProject.class, CreateProjectCommandHandler.of(projectRepository, eventEventDispatcher()));
        commandHandlerMap.put(DeleteProject.class, new DeleteProjectCommandHandler(projectRepository, eventEventDispatcher()));
        commandHandlerMap.put(UpdateProject.class, new UpdateProjectCommandHandler(projectRepository, eventEventDispatcher()));


        return new DefaultCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();

        queryHandlerMap.put(RetrieveUsersByCity.class, new RetrieveUsersByCityHandler(userRepository));
        queryHandlerMap.put(RetrieveUsers.class, new RetrieveUsersHandler(userRepository));
        queryHandlerMap.put(RetrieveUserById.class, new RetrieveUserByIdHandler(userRepository));

        queryHandlerMap.put(RetrieveProjectsByCity.class, new RetrieveProjectsByCityHandler(projectRepository));
        queryHandlerMap.put(RetrieveProjects.class, new RetrieveProjectsHandler(projectRepository));
        queryHandlerMap.put(RetrieveProjectById.class, new RetrieveProjectByIdHandler(projectRepository));

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

    @Bean
    public RetrieveProjectsHandler retrieveProjectsHandler() {
        return new RetrieveProjectsHandler(projectRepository);
    }

    @Bean
    public RetrieveProjectsByCityHandler retrieveProjectsByCityHandler() {
        return new RetrieveProjectsByCityHandler(projectRepository);
    }

    @Bean
    public RetrieveProjectByIdHandler retrieveProjectByIdHandler() {
        return new RetrieveProjectByIdHandler(projectRepository);
    }

}
