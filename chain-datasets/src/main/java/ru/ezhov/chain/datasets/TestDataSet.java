package ru.ezhov.chain.datasets;

import ru.ezhov.chain.common.ChainContext;
import ru.ezhov.chain.common.DataSet;

import java.util.HashMap;
import java.util.Map;

public class TestDataSet implements DataSet {
    public String instruction() {
        return "Test";
    }

    public String version() {
        return "0.1.2.3";
    }

    public Map<String, String> init(String param, ChainContext chainContext) throws Exception {
        return new HashMap<String, String>() {{
            put("test", "test");
        }};
    }
}
