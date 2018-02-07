package ru.ezhov.chain.plugin.exception;

public class ChainLinkJoinException extends Exception {
    public ChainLinkJoinException() {
    }

    public ChainLinkJoinException(String message) {
        super(message);
    }

    public ChainLinkJoinException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChainLinkJoinException(Throwable cause) {
        super(cause);
    }

    public ChainLinkJoinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
