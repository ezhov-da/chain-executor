package ru.ezhov.chain.loader;

import ru.ezhov.chain.core.configuration.Configuration;
import ru.ezhov.chain.plugin.ChainLinkPlugin;
import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractChainPluginContext implements ChainPluginContext {

    protected Map<String, SourcePlugin<Object>> sourceMap;
    protected Map<String, DataSetPlugin<Object>> dataSetMap;
    protected Map<String, ChainLinkPlugin> chainLinkMap;

    protected Configuration configuration;

    public AbstractChainPluginContext(Configuration configuration) {
        this.configuration = configuration;

        sourceMap = new HashMap<String, SourcePlugin<Object>>();
        dataSetMap = new HashMap<String, DataSetPlugin<Object>>();
        chainLinkMap = new HashMap<String, ChainLinkPlugin>();
    }
}
