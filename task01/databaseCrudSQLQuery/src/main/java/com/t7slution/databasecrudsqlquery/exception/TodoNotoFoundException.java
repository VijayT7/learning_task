package com.t7slution.databasecrudsqlquery.exception;

public class TodoNotoFoundException extends RuntimeException {

    public   TodoNotoFoundException(long id) {
        super("Todo with id : " + id + " not found");
    }



}
