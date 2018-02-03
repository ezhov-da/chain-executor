package ru.ezhov.chain.core.configuration;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class PropertiesConfigurationTest {
    private static PropertiesConfiguration propertiesConfiguration;

    @BeforeClass
    public static void initPropertiesConfiguration() throws Exception {
        propertiesConfiguration = new PropertiesConfiguration();
    }

    @Test
    public void getSourceConfiguration() throws Exception {
        assertFalse(propertiesConfiguration.getSourceConfiguration().isEmpty());
    }

    @Test
    public void getDataSetConfiguration() throws Exception {
        assertFalse(propertiesConfiguration.getDataSetConfiguration().isEmpty());
    }

    @Test
    public void getChainLinkConfiguration() throws Exception {
        assertFalse(propertiesConfiguration.getChainLinkConfiguration().isEmpty());
    }

}