package ru.ezhov.chain.sources.test;

import ru.ezhov.chain.common.Source;

public class TestSource implements Source<String> {
    public String instruction() {
        return "Данная реализация источника возвращает текст настройки из конфигурационного файла XML";
    }

    public String version() {
        return "1.2.3.4.5";
    }

    private String testParam;

    public void init(String param) throws Exception {
        this.testParam = param;
    }

    public String getSource() throws Exception {
        return testParam;
    }

    public void preDestroy() {
        System.out.println("Nothing");
    }
}
