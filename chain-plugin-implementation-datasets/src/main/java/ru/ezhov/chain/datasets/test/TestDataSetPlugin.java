package ru.ezhov.chain.datasets.test;

import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.exception.DataSetInitializeException;

import java.util.HashMap;
import java.util.Map;

public class TestDataSetPlugin implements DataSetPlugin {

    @Override
    public void init(String param, Map map) throws DataSetInitializeException {

    }

    public Map<String, String> getDataSet() {
        return new HashMap<>();
    }

    public String instruction() {
        return "Данная реализация возвращает пустую Map с типом Map<String, String>";
    }

    public String version() {
        return "0.1.2.3";
    }


}
