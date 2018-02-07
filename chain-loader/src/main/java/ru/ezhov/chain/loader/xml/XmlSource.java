package ru.ezhov.chain.loader.xml;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "source")
public class XmlSource {

    @XmlAttribute(name = "name", required = true)
    private String name;

    @XmlValue
    private String text;

    XmlSource() {
    }

    XmlSource(String name, String text) {
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
