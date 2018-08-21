package ru.ezhov.configuration;

public class NotLoadingChainConfigurationException extends Exception {
    public NotLoadingChainConfigurationException() {
    }

    public NotLoadingChainConfigurationException(String message) {
        super(message);
    }

    public NotLoadingChainConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLoadingChainConfigurationException(Throwable cause) {
        super(cause);
    }

    public NotLoadingChainConfigurationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
