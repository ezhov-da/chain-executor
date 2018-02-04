package ru.ezhov.chain.datasets.test;

import ru.ezhov.chain.common.ChainContext;
import ru.ezhov.chain.common.DataSet;

import java.util.HashMap;
import java.util.Map;

public class TestDataSet implements DataSet {
    public String instruction() {
        return "Данная реализация возвращает пустую Map с типом Map<String, String>";
    }

    public String version() {
        return "0.1.2.3";
    }

    public void init(String param, ChainContext chainContext) throws Exception {

    }

    public Map<String, String> getDataSet() {
        return new HashMap<>();
    }
}
