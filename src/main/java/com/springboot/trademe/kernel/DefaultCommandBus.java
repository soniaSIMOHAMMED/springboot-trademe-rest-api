package com.springboot.trademe.kernel;


import java.util.Map;

public final class DefaultCommandBus implements CommandBus {
    private final Map<Class<? extends Command>, CommandHandler> dataMap;

    public DefaultCommandBus(Map<Class<? extends Command>, CommandHandler> dataMap) {
        this.dataMap = dataMap;
    }

    public static DefaultCommandBus of(Map<Class<? extends Command>, CommandHandler> dataMap){return new DefaultCommandBus(dataMap);}

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
