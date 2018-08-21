package ru.ezhov.chain.plugin.loader.xml;

import org.junit.Test;

import javax.xml.bind.JAXB;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class XmlChainTest {
    @Test
    public void createXmlChainOk() throws Exception {
        final XmlSource xmlSource = new XmlSource("test-name", "test-text");

        XmlInputSources xmlInputSources = new XmlInputSources(Arrays.asList("test", "test2"));

        final XmlDataSet xmlDataSet = new XmlDataSet("test-name", "test-text", xmlInputSources);

        XmlInputDataSet xmlInputDataSet = new XmlInputDataSet(Arrays.asList("test", "test2"));
        final XmlLink xmlLink = new XmlLink("test-name", "test-text", xmlInputSources, xmlInputDataSet);

        XmlChain xmlChain = new XmlChain(
                new ArrayList<XmlSource>() {{
                    add(xmlSource);
                }},
                new ArrayList<XmlDataSet>() {{
                    add(xmlDataSet);
                }},
                new ArrayList<XmlLink>() {{
                    add(xmlLink);
                }}
        );

        StringWriter stringWriter
                = new StringWriter();

        JAXB.marshal(xmlChain, stringWriter);

        System.out.println(stringWriter.toString());

    }
}