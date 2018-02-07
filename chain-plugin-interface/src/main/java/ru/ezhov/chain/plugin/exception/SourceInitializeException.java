package ru.ezhov.chain.plugin.exception;

public class SourceInitializeException extends Exception {
    public SourceInitializeException() {
    }

    public SourceInitializeException(String message) {
        super(message);
    }

    public SourceInitializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SourceInitializeException(Throwable cause) {
        super(cause);
    }

    public SourceInitializeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
