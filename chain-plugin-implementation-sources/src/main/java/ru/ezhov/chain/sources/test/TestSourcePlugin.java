package ru.ezhov.chain.sources.test;

import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.chain.plugin.exception.SourceInitializeException;

public class TestSourcePlugin implements SourcePlugin<String> {
    public String instruction() {
        return "Данная реализация источника возвращает текст настройки из конфигурационного файла XML";
    }

    public String version() {
        return "1.2.3.4.5";
    }

    private String testParam;

    public void init(String param) throws SourceInitializeException {
        this.testParam = param == null ? "" : param.trim();
    }

    public String getSource() throws Exception {
        return testParam;
    }

    public void preDestroy() {
        System.out.println("Nothing");
    }
}
