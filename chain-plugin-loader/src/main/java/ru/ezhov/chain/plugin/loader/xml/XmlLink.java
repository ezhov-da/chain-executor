package ru.ezhov.chain.plugin.loader.xml;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class XmlLink {

    @XmlAttribute(name = "name", required = true)
    private String name;

    @XmlValue
    private String text;

    XmlLink() {
    }

    XmlLink(String name, String text) {
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
