package ru.ezhov.chain.plugin.loader;

import ru.ezhov.chain.core.configuration.ChainConfiguration;
import ru.ezhov.chain.plugin.LinkPlugin;
import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractChainPluginLoader implements ChainPluginLoader {

    protected Map<String, SourcePlugin<Object>> sourceMap;
    protected Map<String, DataSetPlugin<Object>> dataSetMap;
    protected Map<String, LinkPlugin> linkMap;

    protected ChainConfiguration chainConfiguration;

    public AbstractChainPluginLoader(ChainConfiguration chainConfiguration) {
        this.chainConfiguration = chainConfiguration;

        sourceMap = new HashMap<String, SourcePlugin<Object>>();
        dataSetMap = new HashMap<String, DataSetPlugin<Object>>();
        linkMap = new HashMap<String, LinkPlugin>();
    }
}
