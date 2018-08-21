package ru.ezhov.chain.plugin;

import ru.ezhov.chain.plugin.exception.DataSetPluginException;
import ru.ezhov.chain.plugin.exception.LinkInitializeException;
import ru.ezhov.chain.plugin.exception.LinkJoinException;
import ru.ezhov.chain.plugin.exception.SourcePluginException;

import java.util.List;
import java.util.Map;

public interface LinkPlugin extends PluginInfo {

    /**
     * Инициализация параметра из файла
     *
     * @param param - параметры, которые описываются в конфигурационном файле
     * @throws Exception
     */
    void init(String param) throws LinkInitializeException;

    /**
     * Выполнение звена
     *
     * @param sources  - список объектов источников
     * @param dataSets - список объектов наборов данных
     * @throws LinkJoinException - в случае ошибки происходит прерываение выполнения последующих правил
     *                           и происходит вызов всех {@link SourcePlugin#preDestroy()}
     */
    void join(
            List<SourcePlugin> sources,
            List<DataSetPlugin> dataSets
    ) throws LinkJoinException, SourcePluginException, DataSetPluginException;

    @Override
    String instruction();

    @Override
    String version();
}
