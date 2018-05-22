package ru.ezhov.chain.plugin;

import ru.ezhov.chain.plugin.exception.SourceInitializeException;
import ru.ezhov.chain.plugin.exception.SourcePluginException;

public interface SourcePlugin extends PluginInfo {
    /**
     * Первый метод, который вызывается для инициализации источника.
     * Источником может быть что угодно.
     *
     * @param param - параметры, которые будут передаваться из конфигурационного файла
     * @throws SourceInitializeException - в случае возникновение ошибки выполнение контекста прерывается
     */
    void init(String param) throws SourceInitializeException;

    /**
     * @return - любой объект, который потом можно будет получать из источника
     */
    Object getSource() throws SourcePluginException;

    /**
     * Вызывается перед завершением выполнения контекста или в случае ошибки на следующих шагах
     */
    void preDestroy();

    @Override
    String instruction();

    @Override
    String version();
}
