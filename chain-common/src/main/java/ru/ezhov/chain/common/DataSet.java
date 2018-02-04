package ru.ezhov.chain.common;

public interface DataSet<T> extends Info {

    /**
     * Метод инициализирует набор данных
     *
     * @param param        - параметры передаваемые при инициализации контекста из конфигурационного файла
     * @param chainContext - контекст с инициализированными источниками
     * @throws Exception - в случае выбрасывания ошибки, работа контекста прекращается и
     *                   вызываются все {@link Source#preDestroy()}
     */
    void init(String param, ChainContext chainContext) throws Exception;

    /**
     * @return - любой объект, который будет передаваться в каждое правило
     */
    T getDataSet();

    @Override
    String instruction();

    @Override
    String version();
}
