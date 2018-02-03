package ru.ezhov.chain.common;

public interface Info {
    /**
     * Возвращает инструкцию по настройке и работе класса
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
