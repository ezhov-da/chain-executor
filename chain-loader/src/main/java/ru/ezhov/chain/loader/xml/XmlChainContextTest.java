package ru.ezhov.chain.loader.xml;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.ezhov.chain.core.configuration.PropertiesConfiguration;
import ru.ezhov.chain.plugin.ChainLinkPlugin;
import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;

import static org.junit.Assert.assertNotNull;

public class XmlChainContextTest {
    private static ChainContext chainContext;

    @BeforeClass
    public static void init() throws Exception {
        chainContext = new XmlChainPluginContext(
                "./chain.xml",
                new PropertiesConfiguration("./context.properties")
        );
    }

    @Test
    public void getSourceOk() throws Exception {
        SourcePlugin<Object> objectSourcePlugin = chainContext.getSource("test.source");
        assertNotNull(objectSourcePlugin);
    }

    @Test
    public void getSourcesOk() throws Exception {
    }

    @Test
    public void getDataSetOk() throws Exception {
        DataSetPlugin<Object> objectSource = chainContext.getDataSet("test.dataset");
        assertNotNull(objectSource);
    }

    @Test
    public void getDataSetsOk() throws Exception {
    }

    @Test
    public void getChainLinksOk() throws Exception {
        ChainLinkPlugin objectSource = chainContext.getChainLink("test.chainlink");
        assertNotNull(objectSource);

        objectSource.join(chainContext);

        System.out.println(objectSource.version());
    }

}