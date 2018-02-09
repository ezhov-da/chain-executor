package ru.ezhov.chain.core.domain;

public class Link {
    private String name;
    private String version;
    private String instruction;

    private Object source;

    public Link(String name, String version, String instruction, Object source) {
        this.name = name;
        this.version = version;
        this.instruction = instruction;
        this.source = source;
    }

    //TODO: подумать над функционалом
}
