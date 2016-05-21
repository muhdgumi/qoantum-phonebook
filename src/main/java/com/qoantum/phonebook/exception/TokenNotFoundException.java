package com.qoantum.phonebook.exception;

/**
 * Token not found exception
 */
public class TokenNotFoundException extends AbstractRuntimeException {

    public TokenNotFoundException() {
    }

    public TokenNotFoundException(final String message) {
        super(message);
    }

    public TokenNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TokenNotFoundException(final Throwable cause) {
        super(cause);
    }
}
