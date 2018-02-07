package ru.ezhov.configuration;

import ru.ezhov.chain.core.configuration.ChainLinkConfiguration;
import ru.ezhov.chain.core.configuration.Configuration;
import ru.ezhov.chain.core.configuration.DataSetConfiguration;
import ru.ezhov.chain.core.configuration.SourceConfiguration;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesConfiguration implements Configuration {
    private static final String SOURCE = "source.";
    private static final String DATA_SET = "dataset.";
    private static final String CHAIN_LINK = "chainlink.";

    private Properties properties;
    private Set<SourceConfiguration> sourceConfigurationImpls;
    private Set<DataSetConfiguration> dataSetConfigurationImpls;
    private Set<ChainLinkConfiguration> chainLinkConfigurations;

    private String pathToPropertyFile;

    public PropertiesConfiguration(String pathToPropertyFile) throws Exception {
        this.pathToPropertyFile = pathToPropertyFile;

        properties = new Properties();

        properties.load(new FileInputStream(pathToPropertyFile));

        sourceConfigurationImpls = new HashSet<>();
        dataSetConfigurationImpls = new HashSet<>();
        chainLinkConfigurations = new HashSet<>();

        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> objectEntry : entries) {
            String key = objectEntry.getKey().toString();
            String value = objectEntry.getValue().toString();

            if (key.startsWith(SOURCE)) {
                sourceConfigurationImpls.add(new SourceConfigurationImpl(key.replace(SOURCE, ""), value));
            } else if (key.startsWith(DATA_SET)) {
                dataSetConfigurationImpls.add(new DataSetConfigurationImpl(key.replace(DATA_SET, ""), value));
            } else if (key.startsWith(CHAIN_LINK)) {
                chainLinkConfigurations.add(new ChainLinkConfigurationImpl(key.replace(CHAIN_LINK, ""), value));
            }
        }
    }

    public Set<SourceConfiguration> getSourceConfiguration() {
        return sourceConfigurationImpls;
    }

    public Set<DataSetConfiguration> getDataSetConfiguration() {
        return dataSetConfigurationImpls;
    }

    public Set<ChainLinkConfiguration> getChainLinkConfiguration() {
        return chainLinkConfigurations;
    }
}
