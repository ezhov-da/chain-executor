package ru.ezhov.sql.executor;

public interface Rule {
    /**
     * Выполнение правила
     *
     * @param context - проинициализированный контекст
     * @throws Exception - в случае ошибки происходит прерываение выполнения последующих правил
     *                   и происходит вызов всех {@link Source#preDestroy()}
     */
    void execute(Context context) throws Exception;
}
