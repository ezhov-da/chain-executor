package ru.ezhov.chain.core.context.xml;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.ezhov.chain.common.ChainContext;
import ru.ezhov.chain.common.ChainLink;
import ru.ezhov.chain.common.DataSet;
import ru.ezhov.chain.common.Source;
import ru.ezhov.chain.core.configuration.PropertiesConfiguration;

import static org.junit.Assert.assertNotNull;

public class XmlChainContextTest {
    private static ChainContext chainContext;

    @BeforeClass
    public static void init() throws Exception {
        chainContext = new XmlChainContext(
                "./chain.xml",
                new PropertiesConfiguration("./context.properties")
        );
    }

    @Test
    public void getSourceOk() throws Exception {
        Source<Object> objectSource = chainContext.getSource("test.source");
        assertNotNull(objectSource);
    }

    @Test
    public void getSourcesOk() throws Exception {
    }

    @Test
    public void getDataSetOk() throws Exception {
        DataSet<Object> objectSource = chainContext.getDataSet("test.dataset");
        assertNotNull(objectSource);
    }

    @Test
    public void getDataSetsOk() throws Exception {
    }

    @Test
    public void getChainLinksOk() throws Exception {
        ChainLink objectSource = chainContext.getChainLink("test.chainlink");
        assertNotNull(objectSource);

        objectSource.execute(chainContext);

        System.out.println(objectSource.version());
    }

}