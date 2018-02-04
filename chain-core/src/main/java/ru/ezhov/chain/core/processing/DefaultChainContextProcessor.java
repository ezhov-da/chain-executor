package ru.ezhov.chain.core.processing;

import ru.ezhov.chain.common.ChainContext;
import ru.ezhov.chain.common.ChainLink;
import ru.ezhov.chain.common.Source;

import java.util.List;
import java.util.Set;

public class DefaultChainContextProcessor implements ChainContextProcessor {
    private ChainContext chainContext;

    public DefaultChainContextProcessor(ChainContext chainContext) {
        this.chainContext = chainContext;
    }

    @Override
    public void process() {
        List<ChainLink> chainLinkList = chainContext.getChainLinks();

        try {
            for (ChainLink chainLink : chainLinkList) {
                chainLink.execute(chainContext);
            }
        } catch (Exception e) {
            executeAllPredestroyMethods();
            e.printStackTrace();
        }
    }

    private void executeAllPredestroyMethods() {
        Set<Source<Object>> sourceSet = chainContext.getSources();
        sourceSet.forEach(source -> source.preDestroy());
    }
}
