package ru.ezhov.chain.plugin;

import ru.ezhov.chain.plugin.exception.LinkInitializeException;
import ru.ezhov.chain.plugin.exception.LinkJoinException;
import ru.ezhov.chain.plugin.exception.SourcePluginException;

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
     * @param sourceMap  - словарь источников
     * @param dataSetMap - словарь наборов данных
     * @throws LinkJoinException - в случае ошибки происходит прерываение выполнения последующих правил
     *                           и происходит вызов всех {@link SourcePlugin#preDestroy()}
     */
    void join(
            Map<String, Object> sourceMap,
            Map<String, Object> dataSetMap
    ) throws LinkJoinException, SourcePluginException;

    @Override
    String instruction();

    @Override
    String version();
}
