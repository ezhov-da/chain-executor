package ru.ezhov.chain.sources;

import ru.ezhov.chain.common.Source;

public class TestSource implements Source<String> {
    public String instruction() {
        return "Test";
    }

    public String version() {
        return "1.2.3.4.5";
    }

    public String init(String param) throws Exception {
        return param;
    }

    public void preDestroy() {
        System.out.println("Nothing");
    }
}
