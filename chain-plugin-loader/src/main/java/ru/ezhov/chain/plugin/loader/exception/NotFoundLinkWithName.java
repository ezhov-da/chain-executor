package ru.ezhov.chain.plugin.loader.exception;

public class NotFoundLinkWithName extends Exception {
    public NotFoundLinkWithName() {
    }

    public NotFoundLinkWithName(String message) {
        super(message);
    }

    public NotFoundLinkWithName(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundLinkWithName(Throwable cause) {
        super(cause);
    }

    public NotFoundLinkWithName(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
