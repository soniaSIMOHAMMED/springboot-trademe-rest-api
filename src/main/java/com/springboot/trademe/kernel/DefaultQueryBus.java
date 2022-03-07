package com.springboot.trademe.kernel;

import java.util.Map;

public final class DefaultQueryBus implements QueryBus {
    private final Map<Class<? extends Query>, QueryHandler> dataMap;

    public DefaultQueryBus(Map<Class<? extends Query>, QueryHandler> dataMap) {
        this.dataMap = dataMap;
    }

    public static DefaultQueryBus of(Map<Class<? extends Query>, QueryHandler> dataMap){return new DefaultQueryBus(dataMap);}

    @Override
    public <Q extends Query, R> R send(Q query) {
        return dispatch(query);
    }

    private <Q extends Query, R> R dispatch(Q query) {
        final QueryHandler queryHandler = dataMap.get(query.getClass());
        if (queryHandler == null) {
            throw new RuntimeException("No such query handler for " + query.getClass().getName());
        }

        return (R) queryHandler.handle(query);
    }
}
