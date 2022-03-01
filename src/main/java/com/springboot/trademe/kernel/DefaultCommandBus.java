package com.springboot.trademe.kernel;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class DefaultCommandBus implements CommandBus {
    private final Map<Class<? extends Command>, CommandHandler> dataMap;

    public DefaultCommandBus(Map<Class<? extends Command>, CommandHandler> dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public <C extends Command, R> R send(C command) {
        return dispatch(command);
    }


    private <C extends Command, R> R dispatch(C command) {
        final CommandHandler commandHandler = dataMap.get(command.getClass());
        if (commandHandler == null) {
            throw new RuntimeException("No such command handler for " + command.getClass().getName());
        }

        return (R) commandHandler.handle(command);
    }
}
