package com.springboot.trademe.kernel;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}
