package ru.ezhov.chain.common;

import java.util.List;
import java.util.Set;

public interface ChainContext {
    /**
     * Получение зарегистрированного источника по имени
     *
     * @param name - имя зарегистрированного источника
     * @return
     */
    Source<Object> getSource(String name);

    /**
     * Получение всех источников
     *
     * @return список источников данных
     */

    Set<Source<Object>> getSources();

    /**
     * Получение зарегистрированного набора данных по имени
     *
     * @param name - имя зарегистрированного набора
     * @return
     */
    DataSet<Object> getDataSet(String name);

    /**
     * Получение всех наборов данных доступных цепочке
     *
     * @return список наборов данных
     */
    Set<DataSet<Object>> getDataSets();

    /**
     * Получение зарегистрированных правил контекста
     *
     * @return List<Rule> - список зарегистрированных правил в контексте
     */
    Set<ChainLink> getChainLinks();
}
