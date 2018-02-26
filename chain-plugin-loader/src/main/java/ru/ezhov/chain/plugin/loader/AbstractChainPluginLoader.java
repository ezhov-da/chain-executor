package ru.ezhov.chain.plugin.loader;

import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.LinkPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.configuration.ChainConfiguration;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractChainPluginLoader implements ChainPluginLoader {

    protected Map<String, SourcePlugin> sourceMap;
    protected Map<String, DataSetPlugin> dataSetMap;
    protected Map<String, LinkPlugin> linkMap;

    protected ChainConfiguration chainConfiguration;

    public AbstractChainPluginLoader(ChainConfiguration chainConfiguration) {
        this.chainConfiguration = chainConfiguration;

        sourceMap = new HashMap<>();
        dataSetMap = new HashMap<>();
        linkMap = new HashMap<>();
    }
}
