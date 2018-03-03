package ru.ezhov.chain.plugin.loader;

import ru.ezhov.chain.plugin.exception.DataSetPluginException;

public interface DataSet {

    String getParams();

    Object getDataSet() throws DataSetPluginException;

    void preDestroy();

    String instruction();

    String version();
}
