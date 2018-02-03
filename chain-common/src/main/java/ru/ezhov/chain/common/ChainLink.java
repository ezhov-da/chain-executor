package ru.ezhov.chain.common;

public interface ChainLink extends Info {
    /**
     * Выполнение правила
     *
     * @param initParam    - параметры, которые описываются в конфигарционном файле
     * @param chainContext - проинициализированный контекст
     * @throws Exception - в случае ошибки происходит прерываение выполнения последующих правил
     *                   и происходит вызов всех {@link Source#preDestroy()}
     */
    void execute(String initParam, ChainContext chainContext) throws Exception;
}
