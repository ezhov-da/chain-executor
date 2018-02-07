package ru.ezhov.chain.loader;

import ru.ezhov.chain.plugin.ChainLinkPlugin;
import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;

import java.util.List;
import java.util.Set;

public interface ChainPluginContext {
    /**
     * Получение зарегистрированного источника по имени
     *
     * @param name - имя зарегистрированного источника
     * @return
     */
    SourcePlugin<Object> getSource(String name);

    /**
     * Получение всех источников
     *
     * @return список источников данных
     */

    Set<SourcePlugin<Object>> getSources();

    /**
     * Получение зарегистрированного набора данных по имени
     *
     * @param name - имя зарегистрированного набора
     * @return
     */
    DataSetPlugin<Object> getDataSet(String name);

    /**
     * Получение всех наборов данных доступных цепочке
     *
     * @return список наборов данных
     */
    Set<DataSetPlugin<Object>> getDataSets();

    /**
     * Получение зарегистрированного обработчика
     *
     * @param name - имя зарегистрированного обработчика
     */
    ChainLinkPlugin getChainLink(String name);

    /**
     * Получение зарегистрированных звеньев контекста
     *
     * @return List<Rule> - список зарегистрированных звеньев в контексте
     */
    List<ChainLinkPlugin> getChainLinks();
}
