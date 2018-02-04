package ru.ezhov.chain.core.exception;

public class NotFoundChainLinkWithName extends Exception {
    public NotFoundChainLinkWithName() {
    }

    public NotFoundChainLinkWithName(String message) {
        super(message);
    }

    public NotFoundChainLinkWithName(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundChainLinkWithName(Throwable cause) {
        super(cause);
    }

    public NotFoundChainLinkWithName(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
