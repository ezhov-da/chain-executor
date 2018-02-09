package ru.ezhov.configuration;

import ru.ezhov.chain.core.configuration.LinkConfiguration;

public class LinkConfigurationImpl implements LinkConfiguration {
    private String name;
    private String implementClass;

    LinkConfigurationImpl(String name, String implementClass) {
        this.name = name;
        this.implementClass = implementClass;
    }

    public String name() {
        return name;
    }

    public String implementClass() {
        return implementClass;
    }

}
