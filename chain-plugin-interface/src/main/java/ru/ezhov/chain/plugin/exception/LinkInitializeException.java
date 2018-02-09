package ru.ezhov.chain.plugin.exception;

public class LinkInitializeException extends Exception {
    public LinkInitializeException() {
    }

    public LinkInitializeException(String message) {
        super(message);
    }

    public LinkInitializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinkInitializeException(Throwable cause) {
        super(cause);
    }

    public LinkInitializeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
