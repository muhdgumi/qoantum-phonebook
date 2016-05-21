package com.qoantum.phonebook.exception;

/**
 * Token not valid exception
 */
public class TokenNotValidException extends AbstractRuntimeException {

    public TokenNotValidException() {
    }

    public TokenNotValidException(String message) {
        super(message);
    }

    public TokenNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenNotValidException(Throwable cause) {
        super(cause);
    }
}
