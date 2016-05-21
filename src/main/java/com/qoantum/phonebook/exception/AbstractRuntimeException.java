package com.qoantum.phonebook.exception;

/**
 * Runtime exception that will be extended by all application runtime exceptions
 */
public class AbstractRuntimeException extends RuntimeException {

    public AbstractRuntimeException() {

        super();
    }

    public AbstractRuntimeException(final String message) {
        super(message);
    }

    public AbstractRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AbstractRuntimeException(final Throwable cause) {
        super(cause);
    }
}
