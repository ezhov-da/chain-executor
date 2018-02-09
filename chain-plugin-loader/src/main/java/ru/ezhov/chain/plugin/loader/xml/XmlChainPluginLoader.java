package ru.ezhov.chain.plugin.loader.xml;

import ru.ezhov.chain.core.configuration.ChainConfiguration;
import ru.ezhov.chain.core.configuration.DataSetConfiguration;
import ru.ezhov.chain.core.configuration.LinkConfiguration;
import ru.ezhov.chain.core.configuration.SourceConfiguration;
import ru.ezhov.chain.plugin.loader.exception.NotFoundLinkWithName;
import ru.ezhov.chain.plugin.loader.exception.NotFoundDataSetWithName;
import ru.ezhov.chain.plugin.loader.exception.NotFoundSourceWithName;
import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.LinkPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.chain.plugin.loader.AbstractChainPluginLoader;

import javax.xml.bind.JAXB;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class XmlChainPluginLoader extends AbstractChainPluginLoader {
    private String pathToXmlChainContext;

    public XmlChainPluginLoader(String pathToXmlChainContext, ChainConfiguration chainConfiguration) throws Exception {
        super(chainConfiguration);
        this.pathToXmlChainContext = pathToXmlChainContext;
        init();
    }

    private void init() throws Exception {
        XmlChain xmlChain = JAXB.unmarshal(new FileInputStream(pathToXmlChainContext), XmlChain.class);

        Set<SourceConfiguration> sourceConfigurations = chainConfiguration.getSourceConfiguration();
        Set<DataSetConfiguration> dataSetConfigurations = chainConfiguration.getDataSetConfiguration();
        Set<LinkConfiguration> linkConfigurations = chainConfiguration.getChainLinkConfiguration();

        initSources(sourceConfigurations, xmlChain.getXmlSources());
        initDataSet(dataSetConfigurations, xmlChain.getXmlDataSets());
        initChainLink(linkConfigurations, xmlChain.getXmlLinks());
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

                dataSetPlugin.init(xmlDataSet.getText(), sourceMap); //TODO: сделать корректную передачу параметра)

                dataSetMap.put(xmlDataSet.getName(), dataSetPlugin);
            } else {
                throw new NotFoundDataSetWithName("Not found data set with name: " + xmlDataSet.getName());
            }
        }
    }

    private void initChainLink(Set<LinkConfiguration> linkConfigurations, List<XmlLink> xmlLinks) throws Exception {
        for (XmlLink xmlLink : xmlLinks) {
            Optional<LinkConfiguration> configurationOptional = linkConfigurations
                    .stream()
                    .filter(
                            sourceConfiguration ->
                                    sourceConfiguration.name().equals(xmlLink.getName())
                    )
                    .findFirst();

            if (configurationOptional.isPresent()) {
                String clazz = configurationOptional.get().implementClass();
                Class<?> sourceClass = Class.forName(clazz);

                LinkPlugin linkPlugin = (LinkPlugin) sourceClass.newInstance();
                linkPlugin.init(xmlLink.getText());
                linkMap.put(xmlLink.getName(), linkPlugin);
            } else {
                throw new NotFoundLinkWithName("Not found chain link with name: " + xmlLink.getName());
            }
        }
    }

    @Override
    public Map<String, SourcePlugin<Object>> getSources() {
        return sourceMap;
    }

    @Override
    public Map<String, DataSetPlugin<Object>> getDataSets() {
        return dataSetMap;
    }

    @Override
    public List<LinkPlugin> getLinks() {
        return (List<LinkPlugin>) linkMap.values();
    }

}