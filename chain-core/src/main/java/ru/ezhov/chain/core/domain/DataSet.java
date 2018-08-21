package ru.ezhov.chain.core.domain;

public interface DataSet {

    Object getDataSet() throws Exception;

    String version();
}
