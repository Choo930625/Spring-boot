package com.equalkey.dev.login.exception;

public class CUserNotFoundException extends RuntimeException {
    public CUserNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public CUserNotFoundException(String msg) {
        super(msg);
    }

    public CUserNotFoundException() {
        super();
    }
}
