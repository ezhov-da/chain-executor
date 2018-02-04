package ru.ezhov.chain.core.context.xml;

import org.junit.Test;

import javax.xml.bind.JAXB;
import java.io.StringWriter;
import java.util.ArrayList;

public class XmlChainTest {
    @Test
    public void createXmlChainOk() throws Exception {
        final XmlSource xmlSource = new XmlSource("test-name", "test-text");
        final XmlDataSet xmlDataSet = new XmlDataSet("test-name", "test-text");
        final XmlChainLink xmlChainLink = new XmlChainLink("test-name", "test-text");

        XmlChain xmlChain = new XmlChain(
                new ArrayList<XmlSource>() {{
                    add(xmlSource);
                }},
                new ArrayList<XmlDataSet>() {{
                    add(xmlDataSet);
                }},
                new ArrayList<XmlChainLink>() {{
                    add(xmlChainLink);
                }}
        );

        StringWriter stringWriter
                = new StringWriter();

        JAXB.marshal(xmlChain, stringWriter);

        System.out.println(stringWriter.toString());

    }
}