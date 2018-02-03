package ru.ezhov.chain.common;

public interface DataSet<T> extends Info{

    /**
     * Метод инициализирует набор данных
     *
     * @param param - параметры передаваемые при инициализации контекста из конфигурационного файла
     * @param chainContext - контекст с инициализированными источниками
     * @return - любой объект, который будет передаваться в каждое правило
     * @throws Exception - в случае выбрасывания ошибки, работа контекста прекращается и
     *                   вызываются все {@link Source#preDestroy()}
     */
    T init(String param, ChainContext chainContext) throws Exception;
}
