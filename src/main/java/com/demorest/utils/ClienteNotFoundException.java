package com.demorest.utils;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(final String error) {
        super(error);
    }

}
