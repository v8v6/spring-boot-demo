package com.example.springbootdemo.event;

import org.springframework.context.ApplicationEvent;

public class LogonEvent extends ApplicationEvent {

    private final String userName;

    public LogonEvent(Object source, String username) {
        super(source);
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }
}
