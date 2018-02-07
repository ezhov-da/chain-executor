package ru.ezhov.chain.loader.xml;

import ru.ezhov.chain.core.configuration.ChainLinkConfiguration;
import ru.ezhov.chain.core.configuration.Configuration;
import ru.ezhov.chain.core.configuration.DataSetConfiguration;
import ru.ezhov.chain.core.configuration.SourceConfiguration;
import ru.ezhov.chain.core.exception.NotFoundChainLinkWithName;
import ru.ezhov.chain.core.exception.NotFoundDataSetWithName;
import ru.ezhov.chain.core.exception.NotFoundSourceWithName;
import ru.ezhov.chain.loader.AbstractChainPluginContext;
import ru.ezhov.chain.plugin.ChainLinkPlugin;
import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;

import javax.xml.bind.JAXB;
import java.io.FileInputStream;
import java.util.*;

public class XmlChainPluginContext extends AbstractChainPluginContext {
    private String pathToXmlChainContext;

    public XmlChainPluginContext(String pathToXmlChainContext, Configuration configuration) throws Exception {
        super(configuration);
        this.pathToXmlChainContext = pathToXmlChainContext;
        init();
    }

    private void init() throws Exception {
        XmlChain xmlChain = JAXB.unmarshal(new FileInputStream(pathToXmlChainContext), XmlChain.class);

        Set<SourceConfiguration> sourceConfigurations = configuration.getSourceConfiguration();
        Set<DataSetConfiguration> dataSetConfigurations = configuration.getDataSetConfiguration();
        Set<ChainLinkConfiguration> chainLinkConfigurations = configuration.getChainLinkConfiguration();

        initSources(sourceConfigurations, xmlChain.getXmlSources());
        initDataSet(dataSetConfigurations, xmlChain.getXmlDataSets());
        initChainLink(chainLinkConfigurations, xmlChain.getXmlChainLinks());
    }

    private void initSources(Set<SourceConfiguration> sourceConfigurations, List<XmlSource> xmlSources) throws Exception {
        for (XmlSource xmlSource : xmlSources) {
            Optional<SourceConfiguration> configurationOptional = sourceConfigurations
                    .stream()
                    .filter(
                            sourceConfiguration ->
                                    sourceConfiguration.name().equals(xmlSource.getName())
                    )
                    .findFirst();

            if (configurationOptional.isPresent()) {
                String clazz = configurationOptional.get().implementClass();
                Class<?> sourceClass = Class.forName(clazz);

                SourcePlugin sourcePlugin = (SourcePlugin) sourceClass.newInstance();
                sourcePlugin.init(xmlSource.getText());

                sourceMap.put(xmlSource.getName(), sourcePlugin);
            } else {
                throw new NotFoundSourceWithName("Not found source with name: " + xmlSource.getName());
            }
        }
    }

    private void initDataSet(Set<DataSetConfiguration> dataSetConfigurations, List<XmlDataSet> xmlDataSets) throws Exception {
        for (XmlDataSet xmlDataSet : xmlDataSets) {
            Optional<DataSetConfiguration> configurationOptional = dataSetConfigurations
                    .stream()
                    .filter(
                            dataSetConfiguration ->
                                    dataSetConfiguration.name().equals(xmlDataSet.getName())
                    )
                    .findFirst();

            if (configurationOptional.isPresent()) {
                String clazz = configurationOptional.get().implementClass();
                Class<?> sourceClass = Class.forName(clazz);

                DataSetPlugin dataSetPlugin = (DataSetPlugin) sourceClass.newInstance();
                dataSetPlugin.init(xmlDataSet.getText(), null); //TODO: сделать корректную передачу параметра)

                dataSetMap.put(xmlDataSet.getName(), dataSetPlugin);
            } else {
                throw new NotFoundDataSetWithName("Not found data set with name: " + xmlDataSet.getName());
            }
        }
    }

    private void initChainLink(Set<ChainLinkConfiguration> chainLinkConfigurations, List<XmlChainLink> xmlChainLinks) throws Exception {
        for (XmlChainLink xmlChainLink : xmlChainLinks) {
            Optional<ChainLinkConfiguration> configurationOptional = chainLinkConfigurations
                    .stream()
                    .filter(
                            sourceConfiguration ->
                                    sourceConfiguration.name().equals(xmlChainLink.getName())
                    )
                    .findFirst();

            if (configurationOptional.isPresent()) {
                String clazz = configurationOptional.get().implementClass();
                Class<?> sourceClass = Class.forName(clazz);

                ChainLinkPlugin chainLinkPlugin = (ChainLinkPlugin) sourceClass.newInstance();
                chainLinkPlugin.init(xmlChainLink.getText());
                chainLinkMap.put(xmlChainLink.getName(), chainLinkPlugin);
            } else {
                throw new NotFoundChainLinkWithName("Not found chain link with name: " + xmlChainLink.getName());
            }
        }
    }

    public SourcePlugin<Object> getSource(String name) {
        return sourceMap.get(name);
    }

    public Set<SourcePlugin<Object>> getSources() {
        return new HashSet<>(sourceMap.values());
    }

    public DataSetPlugin<Object> getDataSet(String name) {
        return dataSetMap.get(name);
    }


    public Set<DataSetPlugin<Object>> getDataSets() {
        return new HashSet<>(dataSetMap.values());
    }

    @Override
    public ChainLinkPlugin getChainLink(String name) {
        return chainLinkMap.get(name);
    }

    public List<ChainLinkPlugin> getChainLinks() {
        Collection<ChainLinkPlugin> chainLinkPlugins = chainLinkMap.values();
        return new ArrayList<>(chainLinkPlugins);
    }
}