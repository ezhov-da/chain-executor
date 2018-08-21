package ru.ezhov.chain.plugin.loader.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XmlDataSet {
    @XmlAttribute(name = "name", required = true)
    private String name;

    @XmlElement(name = "param")
    private String param;

    @XmlElement(name = "input-sources")
    private XmlInputSources xmlInputSources;

    XmlDataSet() {
    }

    XmlDataSet(String name, String param, XmlInputSources xmlInputSources) {
        this.name = name;
        this.param = param;
        this.xmlInputSources = xmlInputSources;
    }

    public String getName() {
        return name;
    }

    public String getParam() {
        return param;
    }

    public XmlInputSources getXmlInputSources() {
        return xmlInputSources;
    }
}
