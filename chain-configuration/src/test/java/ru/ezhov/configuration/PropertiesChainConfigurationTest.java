package ru.ezhov.configuration;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class PropertiesChainConfigurationTest {
    private static PropertiesChainConfiguration propertiesConfiguration;

    @BeforeClass
    public static void initPropertiesConfiguration() throws Exception {
        propertiesConfiguration = new PropertiesChainConfiguration("./chain-config.properties");
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