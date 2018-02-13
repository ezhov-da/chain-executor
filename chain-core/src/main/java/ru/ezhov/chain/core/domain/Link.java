


package ru.ezhov.chain.core.domain;

public class Link { 
    void join() throws LinkJoinException;

    String instruction();

    String version();
}
