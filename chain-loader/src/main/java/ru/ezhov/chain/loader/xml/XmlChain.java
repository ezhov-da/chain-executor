package ru.ezhov.chain.loader.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "chain")
public class XmlChain {

    @XmlElement(name = "source")
    @XmlElementWrapper(name = "sources")
    private List<XmlSource> xmlSources;

    @XmlElement(name = "data-set")
    @XmlElementWrapper(name = "data-sets")
    private List<XmlDataSet> xmlDataSets;

    @XmlElement(name = "chain-link")
    @XmlElementWrapper(name = "chain-links")
    private List<XmlChainLink> xmlChainLinks;

    XmlChain() {
    }

    XmlChain(
            List<XmlSource> xmlSources,
            List<XmlDataSet> xmlDataSets,
            List<XmlChainLink> xmlChainLinks
    ) {
        this.xmlSources = xmlSources;
        this.xmlDataSets = xmlDataSets;
        this.xmlChainLinks = xmlChainLinks;
    }

    public List<XmlSource> getXmlSources() {
        return xmlSources;
    }

    public List<XmlDataSet> getXmlDataSets() {
        return xmlDataSets;
    }

    public List<XmlChainLink> getXmlChainLinks() {
        return xmlChainLinks;
    }
}
