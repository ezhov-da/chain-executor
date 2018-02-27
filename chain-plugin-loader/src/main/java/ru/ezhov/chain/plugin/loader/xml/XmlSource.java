package ru.ezhov.chain.plugin.loader.xml;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "source")
public class XmlSource {

    @XmlAttribute(name = "name", required = true)
    private String name;

    @XmlElement(name = "param")
    private String param;

    XmlSource() {
    }

    XmlSource(String name, String param) {
        this.name = name;
        this.param = param;
    }

    public String getName() {
        return name;
    }

    public String getParam() {
        return param;
    }
}
