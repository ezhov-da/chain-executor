package ru.ezhov.chain.core.processing;

import ru.ezhov.chain.common.ChainContext;

public class ChainContextProcessor {
    private ChainContext chainContext;

    public ChainContextProcessor(ChainContext chainContext) {
        this.chainContext = chainContext;
    }

    void process() {
        System.out.println("process");
    }
}
