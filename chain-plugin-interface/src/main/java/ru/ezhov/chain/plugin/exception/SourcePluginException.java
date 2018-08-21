package ru.ezhov.chain.plugin.exception;

public class SourcePluginException extends Exception {

    public SourcePluginException() {
    }

    public SourcePluginException(String message) {
        super(message);
    }

    public SourcePluginException(String message, Throwable cause) {
        super(message, cause);
    }

    public SourcePluginException(Throwable cause) {
        super(cause);
    }

    public SourcePluginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
