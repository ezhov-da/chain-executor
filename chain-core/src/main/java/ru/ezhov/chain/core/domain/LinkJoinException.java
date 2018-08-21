package ru.ezhov.chain.core.domain;

public class LinkJoinException extends Exception {
    public LinkJoinException() {
    }

    public LinkJoinException(String message) {
        super(message);
    }

    public LinkJoinException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinkJoinException(Throwable cause) {
        super(cause);
    }

    public LinkJoinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
