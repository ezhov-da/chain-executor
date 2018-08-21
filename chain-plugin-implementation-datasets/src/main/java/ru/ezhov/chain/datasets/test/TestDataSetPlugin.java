package ru.ezhov.chain.datasets.test;

import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.chain.plugin.exception.DataSetInitializeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataSetPlugin implements DataSetPlugin {

    @Override
    public void init(String param, List<SourcePlugin> sourcePlugins) throws DataSetInitializeException {

    }

    public List<String> getDataSet() {
        return new ArrayList<>();
    }

    @Override
    public void preDestroy() {

    }

    public String instruction() {
        return "Данная реализация возвращает пустую Map с типом Map<String, String>";
    }

    public String version() {
        return "0.1.2.3";
    }


}
