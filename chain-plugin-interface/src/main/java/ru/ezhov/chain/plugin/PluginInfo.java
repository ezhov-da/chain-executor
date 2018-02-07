package ru.ezhov.chain.plugin;

public interface PluginInfo {
    /**
     * Возвращает инструкцию по настройке и работе плагина
     *
     * @return - описание объекта
     */
    String instruction();

    /**
     * Возвращает номер версии
     *
     * @return - номер версии
     */
    String version();

}
