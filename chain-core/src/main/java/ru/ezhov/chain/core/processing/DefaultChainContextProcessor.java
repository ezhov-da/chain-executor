package ru.ezhov.chain.core.processing;

import ru.ezhov.chain.plugin.ChainLinkPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;

import java.util.List;
import java.util.Set;

public class DefaultChainContextProcessor implements ChainContextProcessor {
    private ChainContext chainContext;

    public DefaultChainContextProcessor(ChainContext chainContext) {
        this.chainContext = chainContext;
    }

    @Override
    public void process() {
        List<ChainLinkPlugin> chainLinkPluginList = chainContext.getChainLinks();

        try {
            for (ChainLinkPlugin chainLinkPlugin : chainLinkPluginList) {
                chainLinkPlugin.join(chainContext);
            }
        } catch (Exception e) {
            executeAllPredestroyMethods();
            e.printStackTrace();
        }
    }

    private void executeAllPredestroyMethods() {
        Set<SourcePlugin<Object>> sourcePluginSet = chainContext.getSources();
        sourcePluginSet.forEach(source -> source.preDestroy());
    }
}
