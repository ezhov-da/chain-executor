package ru.ezhov.chain.plugin;

import ru.ezhov.chain.plugin.exception.ChainLinkInitializeException;
import ru.ezhov.chain.plugin.exception.ChainLinkJoinException;

import java.util.Map;

public interface ChainLinkPlugin extends PluginInfo {

    /**
     * Инициализация параметра из файла
     *
     * @param param - параметры, которые описываются в конфигурационном файле
     * @throws Exception
     */
    void init(String param) throws ChainLinkInitializeException;

    /**
     * Выполнение звена
     *
     * @param sourceMap  - словарь источников
     * @param dataSetMap - словарь наборов данных
     * @throws ChainLinkJoinException - в случае ошибки происходит прерываение выполнения последующих правил
     *                                и происходит вызов всех {@link SourcePlugin#preDestroy()}
     */
    void join(
            Map<String, Object> sourceMap,
            Map<String, Object> dataSetMap
    ) throws ChainLinkJoinException;

    @Override
    String instruction();

    @Override
    String version();
}
