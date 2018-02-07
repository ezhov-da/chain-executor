package ru.ezhov.configuration;

import ru.ezhov.chain.core.configuration.DataSetConfiguration;

public class DataSetConfigurationImpl implements DataSetConfiguration {
    private String name;
    private String implementClass;

    DataSetConfigurationImpl(String name, String implementClass) {
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
