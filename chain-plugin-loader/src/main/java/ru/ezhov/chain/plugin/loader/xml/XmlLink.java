package ru.ezhov.chain.plugin.loader.xml;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XmlLink {

    @XmlAttribute(name = "name", required = true)
    private String name;

    @XmlElement(name = "param")
    private String param;

    @XmlElement(name = "input-sources")
    private XmlInputSources xmlInputSources;

    @XmlElement(name = "input-dataset")
    private XmlInputDataSet xmlInputDataSet;

    XmlLink() {
    }

    XmlLink(
            String name,
            String param,
            XmlInputSources xmlInputSources,
            XmlInputDataSet xmlInputDataSet) {
        this.name = name;
        this.param = param;
        this.xmlInputSources = xmlInputSources;
        this.xmlInputDataSet = xmlInputDataSet;
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

    public XmlInputDataSet getXmlInputDataSet() {
        return xmlInputDataSet;
    }
}
