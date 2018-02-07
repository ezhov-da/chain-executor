package ru.ezhov.chain.core.domain;

import ru.ezhov.chain.core.SourceDestroyAction;

public class Source {
    private String name;
    private String version;
    private String instruction;

    private Object source;

    public Source(String name, String version, String instruction, Object source) {
        this.name = name;
        this.version = version;
        this.instruction = instruction;
        this.source = source;
    }

    private void preDestroyAction(SourceDestroyAction sourceDestroyAction) {
        sourceDestroyAction.perform();
    }

    private Object source() {
        return source;
    }
}
