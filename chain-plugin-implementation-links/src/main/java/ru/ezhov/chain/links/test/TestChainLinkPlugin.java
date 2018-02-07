package ru.ezhov.chain.links.test;

import ru.ezhov.chain.plugin.ChainLinkPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;

public class TestChainLinkPlugin implements ChainLinkPlugin {
    private String initParam;

    public String instruction() {
        return "Данная реализация получает текст из кофигурационного файла и источника, считает кол-во символов, суммирует и выводит результат";
    }

    public String version() {
        return "1.2.3.4.5";
    }

    @Override
    public void init(String param) throws Exception {
        this.initParam = param == null ? "" : param.trim();
    }

    @Override
    public void execute(ChainContext chainContext) throws Exception {
        SourcePlugin<String> stringSourcePlugin =
                (SourcePlugin<String>)
                        (SourcePlugin<?>) chainContext.getSource("test.source");

        String sourceText = stringSourcePlugin.getSource();
        System.out.println("SourcePlugin text: " + sourceText);
        System.out.println("\tcount char source text: " + sourceText.length());
        System.out.println("Param text: " + initParam);
        System.out.println("\tcount char param text: " + initParam.length());
        System.out.println("Result text: " + sourceText + initParam);
        System.out.println("\tcount char result text: " + (sourceText + initParam).length());
    }

}
