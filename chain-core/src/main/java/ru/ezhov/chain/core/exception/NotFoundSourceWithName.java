package ru.ezhov.chain.core.exception;

public class NotFoundSourceWithName extends Exception {

    public NotFoundSourceWithName() {
    }

    public NotFoundSourceWithName(String message) {
        super(message);
    }

    public NotFoundSourceWithName(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundSourceWithName(Throwable cause) {
        super(cause);
    }

    public NotFoundSourceWithName(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
