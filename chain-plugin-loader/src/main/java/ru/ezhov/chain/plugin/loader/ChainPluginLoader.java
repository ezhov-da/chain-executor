package ru.ezhov.chain.plugin.loader;

import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.LinkPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;

import java.util.List;
import java.util.Map;

public interface ChainPluginLoader {
    /**
     * Получение всех источников
     *
     * @return список источников данных
     */

    Map<String, SourcePlugin> getSources();

    /**
     * Получение всех наборов данных доступных цепочке
     *
     * @return список наборов данных
     */
    Map<String, DataSetPlugin> getDataSets();

    /**
     * Получение зарегистрированных звеньев контекста
     *
     * @return List<Rule> - список зарегистрированных звеньев в контексте
     */
    Map<String, LinkPlugin> getLinks();
}
