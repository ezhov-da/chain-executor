package ru.ezhov.chain.plugin;

import ru.ezhov.chain.plugin.exception.DataSetInitializeException;
import ru.ezhov.chain.plugin.exception.DataSetPluginException;

import java.util.List;

public interface DataSetPlugin extends PluginInfo {

    /**
     * Метод инициализирует набор данных
     *
     * @param param   - параметры передаваемые при инициализации контекста из конфигурационного файла
     * @param sources - массив ожидаемых объектов источников для получения набора данных
     *                <p/>
     *                В случае выбрасывания ошибки, работа контекста прекращается и
     *                вызываются все {@link SourcePlugin#preDestroy()}
     */
    void init(String param, List<SourcePlugin> sources) throws DataSetInitializeException;

    /**
     * @return - любой объект, который будет передаваться в каждое правило
     */
    Object getDataSet() throws DataSetPluginException;

    void preDestroy();

    @Override
    String instruction();

    @Override
    String version();
}
