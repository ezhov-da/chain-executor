package ru.ezhov.chain.core.configuration;

public class ChainLinkConfiguration implements ConfigurationInfo {
    private String name;
    private String implementClass;

    ChainLinkConfiguration(String name, String implementClass) {
        this.name = name;
        this.implementClass = implementClass;
    }

    public String getName() {
        return name;
    }

    public String getImplementClass() {
        return implementClass;
    }

}
