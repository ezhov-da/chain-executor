package ru.ezhov.chain.common;

public interface ChainLink extends Info {

    /**
     * Инициализация параметра из файла
     *
     * @param initParam - параметры, которые описываются в конфигурационном файле
     * @throws Exception
     */
    void setInitParam(String initParam) throws Exception;

    /**
     * Выполнение правила
     *
     * @param chainContext - проинициализированный контекст
     * @throws Exception - в случае ошибки происходит прерываение выполнения последующих правил
     *                   и происходит вызов всех {@link Source#preDestroy()}
     */
    void execute(ChainContext chainContext) throws Exception;

    @Override
    String instruction();

    @Override
    String version();
}
