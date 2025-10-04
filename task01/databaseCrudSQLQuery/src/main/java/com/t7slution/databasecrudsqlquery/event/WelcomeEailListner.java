package com.t7slution.databasecrudsqlquery.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEailListner {
    @EventListener
    public void handleUserRegistered (UserRegisteredEvent event){
        System.out.println("WelcomeEailListner handleUserRegistered " + event.getUsername());
    }
}
