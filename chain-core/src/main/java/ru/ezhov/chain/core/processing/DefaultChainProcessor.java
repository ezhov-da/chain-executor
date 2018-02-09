package ru.ezhov.chain.core.processing;

import ru.ezhov.chain.core.domain.Chain;

public class DefaultChainProcessor implements ChainProcessor {
    private Chain chainContext;

    public DefaultChainProcessor(Chain chainContext) {
        this.chainContext = chainContext;
    }

    @Override
    public void process() {
        chainContext.build();
    }
}
