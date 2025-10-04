package com.t7slution.databasecrudsqlquery.event;

public class UserRegisteredEvent {
    private final String username;
    public UserRegisteredEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
