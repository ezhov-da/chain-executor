package ru.ezhov.chain.plugin.exception;

public class DataSetPluginException extends Exception {
    public DataSetPluginException() {
    }

    public DataSetPluginException(String message) {
        super(message);
    }

    public DataSetPluginException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataSetPluginException(Throwable cause) {
        super(cause);
    }

    public DataSetPluginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
