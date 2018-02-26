package ru.ezhov.chain.core.domain;

public interface Link {
    void join() throws LinkJoinException;

    String version();
}
