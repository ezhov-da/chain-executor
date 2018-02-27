package ru.ezhov.chain.plugin.loader.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class XmlInputSources {

    public XmlInputSources() {
    }

    public XmlInputSources(List<String> names) {
        this.names = names;
    }

    @XmlElement(name = "name")
    private List<String> names;

    public List<String> getNames() {
        return names;
    }
}
