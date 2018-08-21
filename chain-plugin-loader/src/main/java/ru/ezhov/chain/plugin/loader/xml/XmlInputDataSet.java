package ru.ezhov.chain.plugin.loader.xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class XmlInputDataSet {
    @XmlElement(name = "name")
    private List<String> names;

    public XmlInputDataSet() {
    }

    public XmlInputDataSet(List<String> names) {

        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }
}
