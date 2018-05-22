package ru.ezhov.configuration;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesChainConfiguration implements ChainConfiguration {
    private static final String SOURCE = "source.";
    private static final String DATA_SET = "dataset.";
    private static final String CHAIN_LINK = "chainlink.";

    private Properties properties;
    private Set<SourceConfiguration> sourceConfigurationImpls;
    private Set<DataSetConfiguration> dataSetConfigurationImpls;
    private Set<LinkConfiguration> linkConfigurations;

    private String pathToPropertyFile;

    public PropertiesChainConfiguration(String pathToPropertyFile) throws NotLoadingChainConfigurationException {
        this.pathToPropertyFile = pathToPropertyFile;

        try {
            properties = new Properties();
            properties.load(new FileInputStream(pathToPropertyFile));

            sourceConfigurationImpls = new HashSet<>();
            dataSetConfigurationImpls = new HashSet<>();
            linkConfigurations = new HashSet<>();

            Set<Map.Entry<Object, Object>> entries = properties.entrySet();
            for (Map.Entry<Object, Object> objectEntry : entries) {
                String key = objectEntry.getKey().toString();
                String value = objectEntry.getValue().toString();

                if (key.startsWith(SOURCE)) {
                    sourceConfigurationImpls.add(new SourceConfigurationImpl(key.replace(SOURCE, ""), value));
                } else if (key.startsWith(DATA_SET)) {
                    dataSetConfigurationImpls.add(new DataSetConfigurationImpl(key.replace(DATA_SET, ""), value));
                } else if (key.startsWith(CHAIN_LINK)) {
                    linkConfigurations.add(new LinkConfigurationImpl(key.replace(CHAIN_LINK, ""), value));
                }
            }
        } catch (Exception e) {
            NotLoadingChainConfigurationException notLoadingChainConfigurationException = new NotLoadingChainConfigurationException(e.getMessage());
            notLoadingChainConfigurationException.addSuppressed(e);
            throw notLoadingChainConfigurationException;
        }
    }

    public Set<SourceConfiguration> getSourceConfiguration() {
        return sourceConfigurationImpls;
    }

    public Set<DataSetConfiguration> getDataSetConfiguration() {
        return dataSetConfigurationImpls;
    }

    public Set<LinkConfiguration> getChainLinkConfiguration() {
        return linkConfigurations;
    }
}
