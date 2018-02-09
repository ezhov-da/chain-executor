package ru.ezhov.chain.links.test;

import ru.ezhov.chain.plugin.LinkPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.chain.plugin.exception.LinkJoinException;
import ru.ezhov.chain.plugin.exception.LinkInitializeException;
import ru.ezhov.chain.plugin.exception.SourcePluginException;

import java.util.Map;

public class TestLinkPlugin implements LinkPlugin {
    private String initParam;

    public String instruction() {
        return "Данная реализация получает текст из кофигурационного файла и источника, считает кол-во символов, суммирует и выводит результат";
    }

    public String version() {
        return "1.2.3.4.5";
    }

    @Override
    public void init(String param) throws LinkInitializeException {
        this.initParam = param == null ? "" : param.trim();
    }

    @Override
    public void join(Map<String, Object> sourceMap,
                     Map<String, Object> dataSetMap) throws LinkJoinException, SourcePluginException {
        SourcePlugin<String> stringSourcePlugin =
                (SourcePlugin<String>) sourceMap.get("test.source");

        String sourceText = stringSourcePlugin.getSource();
        System.out.println("SourcePlugin text: " + sourceText);
        System.out.println("\tcount char source text: " + sourceText.length());
        System.out.println("Param text: " + initParam);
        System.out.println("\tcount char param text: " + initParam.length());
        System.out.println("Result text: " + sourceText + initParam);
        System.out.println("\tcount char result text: " + (sourceText + initParam).length());
    }

}
