package ru.ezhov.chain.plugin.exception;

public class ChainLinkInitializeException extends Exception {
    public ChainLinkInitializeException() {
    }

    public ChainLinkInitializeException(String message) {
        super(message);
    }

    public ChainLinkInitializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChainLinkInitializeException(Throwable cause) {
        super(cause);
    }

    public ChainLinkInitializeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
