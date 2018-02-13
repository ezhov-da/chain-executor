package ru.ezhov.chain.core.domain;

public interface Source {
    public void setParam(String param);
    Object getSource() throws SourceException;
    void preDestroy();
    String instruction();
    String version();
}
