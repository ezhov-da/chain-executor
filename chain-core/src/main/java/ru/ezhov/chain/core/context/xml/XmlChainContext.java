package ru.ezhov.chain.core.context.xml;

import ru.ezhov.chain.common.ChainLink;
import ru.ezhov.chain.common.DataSet;
import ru.ezhov.chain.common.Source;
import ru.ezhov.chain.core.configuration.ChainLinkConfiguration;
import ru.ezhov.chain.core.configuration.Configuration;
import ru.ezhov.chain.core.configuration.DataSetConfiguration;
import ru.ezhov.chain.core.configuration.SourceConfiguration;
import ru.ezhov.chain.core.context.AbstractChainContext;
import ru.ezhov.chain.core.exception.NotFoundChainLinkWithName;
import ru.ezhov.chain.core.exception.NotFoundDataSetWithName;
import ru.ezhov.chain.core.exception.NotFoundSourceWithName;

import javax.xml.bind.JAXB;
import java.io.FileInputStream;
import java.util.*;

public class XmlChainContext extends AbstractChainContext {
    private String pathToXmlChainContext;

    public XmlChainContext(String pathToXmlChainContext, Configuration configuration) throws Exception {
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
                                    sourceConfiguration.getName().equals(xmlSource.getName())
                    )
                    .findFirst();

            if (configurationOptional.isPresent()) {
                String clazz = configurationOptional.get().getImplementClass();
                Class<?> sourceClass = Class.forName(clazz);

                Source source = (Source) sourceClass.newInstance();
                source.init(xmlSource.getText());

                sourceMap.put(xmlSource.getName(), source);
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
                                    dataSetConfiguration.getName().equals(xmlDataSet.getName())
                    )
                    .findFirst();

            if (configurationOptional.isPresent()) {
                String clazz = configurationOptional.get().getImplementClass();
                Class<?> sourceClass = Class.forName(clazz);

                DataSet dataSet = (DataSet) sourceClass.newInstance();
                dataSet.init(xmlDataSet.getText(), this);

                dataSetMap.put(xmlDataSet.getName(), dataSet);
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
                                    sourceConfiguration.getName().equals(xmlChainLink.getName())
                    )
                    .findFirst();

            if (configurationOptional.isPresent()) {
                String clazz = configurationOptional.get().getImplementClass();
                Class<?> sourceClass = Class.forName(clazz);

                ChainLink chainLink = (ChainLink) sourceClass.newInstance();
                chainLink.setInitParam(xmlChainLink.getText());
                chainLinkMap.put(xmlChainLink.getName(), chainLink);
            } else {
                throw new NotFoundChainLinkWithName("Not found chain link with name: " + xmlChainLink.getName());
            }
        }
    }

    public Source<Object> getSource(String name) {
        return sourceMap.get(name);
    }

    public Set<Source<Object>> getSources() {
        return new HashSet<>(sourceMap.values());
    }

    public DataSet<Object> getDataSet(String name) {
        return dataSetMap.get(name);
    }


    public Set<DataSet<Object>> getDataSets() {
        return new HashSet<>(dataSetMap.values());
    }

    @Override
    public ChainLink getChainLink(String name) {
        return chainLinkMap.get(name);
    }

    public List<ChainLink> getChainLinks() {
        Collection<ChainLink> chainLinks = chainLinkMap.values();
        return new ArrayList<>(chainLinks);
    }
}