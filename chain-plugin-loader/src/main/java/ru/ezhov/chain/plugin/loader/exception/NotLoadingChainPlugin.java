package ru.ezhov.chain.plugin.loader.exception;

public class NotLoadingChainPlugin extends Exception {
    public NotLoadingChainPlugin() {
    }

    public NotLoadingChainPlugin(String message) {
        super(message);
    }

    public NotLoadingChainPlugin(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLoadingChainPlugin(Throwable cause) {
        super(cause);
    }

    public NotLoadingChainPlugin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
