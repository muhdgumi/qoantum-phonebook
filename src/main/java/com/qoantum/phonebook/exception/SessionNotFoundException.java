package com.qoantum.phonebook.exception;

/**
 * Session not found exception
 */
public class SessionNotFoundException extends AbstractRuntimeException {

    public SessionNotFoundException() {
    }

    public SessionNotFoundException(String message) {
        super(message);
    }

    public SessionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionNotFoundException(Throwable cause) {
        super(cause);
    }
}
