package ru.ezhov.application.console;

import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.loader.ChainPluginLoader;
import ru.ezhov.chain.plugin.loader.exception.NotLoadingChainPlugin;
import ru.ezhov.chain.plugin.loader.xml.XmlChainPluginLoader;
import ru.ezhov.configuration.ChainConfiguration;
import ru.ezhov.configuration.DataSetConfiguration;
import ru.ezhov.configuration.NotLoadingChainConfigurationException;
import ru.ezhov.configuration.PropertiesChainConfiguration;

import java.util.Map;
import java.util.Set;

public class AppConsole {
    public static void main(String[] args) {
        try {
            ChainConfiguration chainConfiguration = new PropertiesChainConfiguration("chain-config.properties");
            Set<DataSetConfiguration> dataSetConfigurations = chainConfiguration.getDataSetConfiguration();

            ChainPluginLoader chainPluginLoader = new XmlChainPluginLoader("chain.xml", chainConfiguration);
            Map<String, DataSetPlugin> dataSetMap = chainPluginLoader.getDataSets();
            Set<Map.Entry<String, DataSetPlugin>> entries = dataSetMap.entrySet();
            for (Map.Entry<String, DataSetPlugin> entry : entries) {
                System.out.printf("key: %s value: %s", entry.getKey(), entry.getValue());
            }
        } catch (NotLoadingChainConfigurationException e) {
            e.printStackTrace();
        } catch (NotLoadingChainPlugin notLoadingChainPlugin) {
            notLoadingChainPlugin.printStackTrace();
        }
    }
}
