package ru.ezhov.chain.links;

import ru.ezhov.chain.common.ChainContext;
import ru.ezhov.chain.common.ChainLink;

public class TestChainLink implements ChainLink {
    public void execute(String initParam, ChainContext chainContext) throws Exception {
        System.out.println(initParam);

    }

    public String instruction() {
        return "Hey";
    }

    public String version() {
        return "1.2.3.4.5";
    }
}
