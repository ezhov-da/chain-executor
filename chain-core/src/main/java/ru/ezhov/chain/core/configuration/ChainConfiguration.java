package ru.ezhov.chain.core.configuration;

import java.util.Set;

public interface ChainConfiguration {
    Set<SourceConfiguration> getSourceConfiguration();

    Set<DataSetConfiguration> getDataSetConfiguration();

    Set<LinkConfiguration> getChainLinkConfiguration();
}
