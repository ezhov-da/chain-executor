package ru.ezhov.chain.plugin.loader;

import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.LinkPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.configuration.ChainConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractChainPluginLoader implements ChainPluginLoader {

    protected Map<String, SourcePlugin> sources;
    protected Map<String, DataSetPlugin> dataSets;
    protected Map<String, LinkPlugin> links;

    protected ChainConfiguration chainConfiguration;

    public AbstractChainPluginLoader(ChainConfiguration chainConfiguration) {
        this.chainConfiguration = chainConfiguration;

        sources = new HashMap<>();
        dataSets = new HashMap<>();
        links = new HashMap<>();
    }
}
