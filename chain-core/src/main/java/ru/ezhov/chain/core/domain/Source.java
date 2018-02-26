package ru.ezhov.chain.core.domain;

public interface Source {
    Object getSource() throws SourceException;

    void preDestroy();

    String version();
}
