package ru.ezhov.chain.core.domain;

public class DataSet {
    private String name;
    private String version;
    private String instruction;

    private Object source;

    public DataSet(String name, String version, String instruction, Object source) {
        this.name = name;
        this.version = version;
        this.instruction = instruction;
        this.source = source;
    }

    private Object dataSet() {
        return source;
    }
}
