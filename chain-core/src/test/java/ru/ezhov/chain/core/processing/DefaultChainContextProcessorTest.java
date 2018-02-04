package ru.ezhov.chain.core.processing;

import org.junit.Test;
import ru.ezhov.chain.core.configuration.PropertiesConfiguration;
import ru.ezhov.chain.core.context.xml.XmlChainContext;

public class DefaultChainContextProcessorTest {
    @Test
    public void processOk() throws Exception {
        ChainContextProcessor chainContextProcessor =
                new DefaultChainContextProcessor(
                        new XmlChainContext(
                                "./chain.xml",
                                new PropertiesConfiguration("./context.properties")
                        )
                );

        chainContextProcessor.process();
    }
}