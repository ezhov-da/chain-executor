package ru.ezhov.chain.sources.test;

import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.chain.plugin.exception.SourceInitializeException;
import ru.ezhov.chain.plugin.exception.SourcePluginException;

public class TestSourcePlugin implements SourcePlugin {
    private String testParam;

    public String instruction() {
        return "Данная реализация источника возвращает текст настройки из конфигурационного файла XML";
    }

    public String version() {
        return "1.2.3.4.5";
    }

    public void init(String param) throws SourceInitializeException {
        this.testParam = param == null ? "" : param.trim();
    }

    public String getSource() throws SourcePluginException {
        return testParam;
    }

    public void preDestroy() {
        System.out.println("Nothing");
    }
}
