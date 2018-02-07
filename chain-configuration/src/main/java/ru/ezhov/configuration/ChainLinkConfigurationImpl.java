package ru.ezhov.configuration;

import ru.ezhov.chain.core.configuration.ChainLinkConfiguration;

public class ChainLinkConfigurationImpl implements ChainLinkConfiguration {
    private String name;
    private String implementClass;

    ChainLinkConfigurationImpl(String name, String implementClass) {
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
