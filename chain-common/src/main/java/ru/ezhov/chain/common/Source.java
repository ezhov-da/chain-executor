package ru.ezhov.chain.common;

public interface Source<T> extends Info {
    /**
     * Первый метод, который вызывается для инициализации источника.
     * Источником может быть что угодно.
     *
     * @param param - параметры, которые будут передаваться из конфигурационного файла
     * @throws Exception - в случае возникновение ошибки выполнение контекста прерывается
     */
    void init(String param) throws Exception;

    /**
     * @return - любой объект, который потом можно будет получать из источника
     * @throws Exception
     */
    T getSource() throws Exception;

    /**
     * Вызывается перед завершением выполнения контекста или в случае ошибки на следующих шагах
     */
    void preDestroy();

    @Override
    String instruction();

    @Override
    String version();
}
