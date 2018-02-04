package ru.ezhov.chain.core.context.xml;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class XmlChainLink {

    @XmlAttribute(name = "name", required = true)
    private String name;

    @XmlValue
    private String text;

    XmlChainLink() {
    }

    XmlChainLink(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
