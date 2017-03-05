package com.majin.mappoi.Utilities;

import com.majin.mappoi.Events.LoginEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Majin on 05/03/2017.
 */

public class CustomEventBus {
    private static CustomEventBus instance;

    private static EventBus eventBus;

    private CustomEventBus() {
        eventBus = EventBus.getDefault();
    }
    public static CustomEventBus getInstance() {
        if (instance == null) {
            instance = new CustomEventBus();
        }
        return instance;
    }

    public void register(Object subscriber) {
        try {
            eventBus.register(subscriber);
        } catch (Exception e) {
        }
    }

    public boolean isRegistered(Object o) {
        return eventBus.isRegistered(o);
    }

    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    public void postLoginEvent (LoginEvent event) {
        eventBus.post(event);
    }
}
