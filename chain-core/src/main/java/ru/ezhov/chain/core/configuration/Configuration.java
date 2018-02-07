package ru.ezhov.chain.core.configuration;

import java.util.Set;

public interface Configuration {
    Set<SourceConfiguration> getSourceConfiguration();

    Set<DataSetConfiguration> getDataSetConfiguration();

    Set<ChainLinkConfiguration> getChainLinkConfiguration();
}
