package com.t7slution.databasecrudsqlquery.services;

import com.t7slution.databasecrudsqlquery.event.UserRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ApplicationEventPublisher publisher;

    public UserService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void registerUser(String username) {

        System.out.println("Registering user " + username);
        UserRegisteredEvent event = new UserRegisteredEvent(username);
        publisher.publishEvent(event);
    }


}


