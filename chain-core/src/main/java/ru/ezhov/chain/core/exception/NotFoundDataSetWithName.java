package ru.ezhov.chain.core.exception;

public class NotFoundDataSetWithName extends Exception {
    public NotFoundDataSetWithName() {
    }

    public NotFoundDataSetWithName(String message) {
        super(message);
    }

    public NotFoundDataSetWithName(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundDataSetWithName(Throwable cause) {
        super(cause);
    }

    public NotFoundDataSetWithName(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
