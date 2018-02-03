package ru.ezhov.chain.core.context;

import ru.ezhov.chain.common.ChainLink;
import ru.ezhov.chain.common.DataSet;
import ru.ezhov.chain.common.Source;
import ru.ezhov.chain.core.configuration.Configuration;

import java.util.Set;

public class XmlChainContext extends AbstractChainContext {

    public XmlChainContext(Configuration configuration) {
        super(configuration);
    }

    public Source<Object> getSource(String name) {
        return null;
    }

    public Set<Source<Object>> getSources() {
        return null;
    }

    public DataSet<Object> getDataSet(String name) {
        return null;
    }

    public Set<DataSet<Object>> getDataSets() {
        return null;
    }

    public Set<ChainLink> getChainLinks() {
        return null;
    }
}
