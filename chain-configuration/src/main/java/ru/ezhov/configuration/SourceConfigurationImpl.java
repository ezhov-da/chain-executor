package ru.ezhov.configuration;

import ru.ezhov.chain.core.configuration.SourceConfiguration;

public class SourceConfigurationImpl implements SourceConfiguration {
    private String name;
    private String implementClass;

    SourceConfigurationImpl(String name, String implementClass) {
        this.name = name;
        this.implementClass = implementClass;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String implementClass() {
        return implementClass;
    }
}
