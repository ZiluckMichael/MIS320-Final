package com.ziluck.iastate.mis320final.exception;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Exception ex) {
        super(message, ex);
    }
}
