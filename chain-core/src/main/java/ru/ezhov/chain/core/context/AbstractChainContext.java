package ru.ezhov.chain.core.context;

import ru.ezhov.chain.common.ChainContext;
import ru.ezhov.chain.common.ChainLink;
import ru.ezhov.chain.common.DataSet;
import ru.ezhov.chain.common.Source;
import ru.ezhov.chain.core.configuration.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractChainContext implements ChainContext {

    protected Map<String, Source<Object>> sourceMap;
    protected Map<String, DataSet<Object>> dataSetMap;
    protected Map<String, ChainLink> chainLinkMap;

    private Configuration configuration;

    public AbstractChainContext(Configuration configuration) {
        this.configuration = configuration;

        sourceMap = new HashMap<String, Source<Object>>();
        dataSetMap = new HashMap<String, DataSet<Object>>();
        chainLinkMap = new HashMap<String, ChainLink>();
    }

    public abstract Source<Object> getSource(String name);

    public abstract Set<Source<Object>> getSources();

    public abstract DataSet<Object> getDataSet(String name);

    public abstract Set<DataSet<Object>> getDataSets();

    public abstract Set<ChainLink> getChainLinks();
}
