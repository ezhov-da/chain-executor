package ru.ezhov.chain.core.infrastructure;

import ru.ezhov.chain.core.configuration.ChainConfiguration;
import ru.ezhov.chain.core.domain.Chain;

public class ChainBuilder {

    public static synchronized Chain build(ChainConfiguration chainConfiguration) {
        return new Chain();
    }
}
