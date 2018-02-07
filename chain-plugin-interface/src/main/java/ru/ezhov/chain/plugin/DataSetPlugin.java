package ru.ezhov.chain.plugin;

import ru.ezhov.chain.plugin.exception.DataSetInitializeException;

import java.util.Map;

public interface DataSetPlugin<T> extends PluginInfo {

    /**
     * Метод инициализирует набор данных
     *
     * @param param           - параметры передаваемые при инициализации контекста из конфигурационного файла
     * @param sourcePluginMap - набор доступных источников имя/источник
     * @throws Exception - в случае выбрасывания ошибки, работа контекста прекращается и
     *                   вызываются все {@link SourcePlugin#preDestroy()}
     */
    void init(String param, Map<String, SourcePlugin> sourcePluginMap) throws DataSetInitializeException;

    /**
     * @return - любой объект, который будет передаваться в каждое правило
     */
    T getDataSet() throws Exception;

    @Override
    String instruction();

    @Override
    String version();
}
