package ru.ezhov.chain.plugin.loader.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "chain")
public class XmlChain {

    @XmlElement(name = "source")
    @XmlElementWrapper(name = "sources")
    private List<XmlSource> xmlSources;

    @XmlElementWrapper(name = "data-sets")
    @XmlElement(name = "data-set")
    private List<XmlDataSet> xmlDataSets;

    @XmlElementWrapper(name = "links")
    @XmlElement(name = "link")
    private List<XmlLink> xmlLinks;

    XmlChain() {
    }

    XmlChain(
            List<XmlSource> xmlSources,
            List<XmlDataSet> xmlDataSets,
            List<XmlLink> xmlLinks
    ) {
        this.xmlSources = xmlSources;
        this.xmlDataSets = xmlDataSets;
        this.xmlLinks = xmlLinks;
    }

    public List<XmlSource> getXmlSources() {
        return xmlSources;
    }

    public List<XmlDataSet> getXmlDataSets() {
        return xmlDataSets;
    }

    public List<XmlLink> getXmlLinks() {
        return xmlLinks;
    }
}
