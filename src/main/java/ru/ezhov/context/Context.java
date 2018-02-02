package ru.ezhov.sql.executor;

import java.util.List;

public interface Context {
    /**
     * Получение зарегистрированного источника по имени
     *
     * @param name - имя зарегистрированного источника
     * @return
     */
    Source<Object> getSource(String name);

    /**
     * Получение зарегистрированного набора данных по имени
     *
     * @param name - имя зарегистрированного набора
     * @return
     */
    DataSet<Object> getDataSet(String name);

    /**
     * Получение зарегистрированных правил контекста
     *
     * @return List<Rule> - список зарегистрированных правил в контексте
     */
    List<Rule> getRules();
}
