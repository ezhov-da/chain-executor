package ru.ezhov.chain.plugin.exception;

public class DataSetInitializeException extends Exception {
    public DataSetInitializeException() {
    }

    public DataSetInitializeException(String message) {
        super(message);
    }

    public DataSetInitializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataSetInitializeException(Throwable cause) {
        super(cause);
    }

    public DataSetInitializeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
