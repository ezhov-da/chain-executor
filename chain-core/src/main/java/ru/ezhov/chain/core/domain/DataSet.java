package ru.ezhov.chain.core.domain;

public interface DataSet {
    void setParam(String param);
    T getDataSet() throws Exception;
    String instruction();
    String version();
}
