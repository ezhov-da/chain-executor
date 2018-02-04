package ru.ezhov.chain.links.test;

import ru.ezhov.chain.common.ChainContext;
import ru.ezhov.chain.common.ChainLink;
import ru.ezhov.chain.common.Source;

public class TestChainLink implements ChainLink {
    private String initParam;

    public String instruction() {
        return "Данная реализация получает текст из кофигурационного файла и источника, считает кол-во символов, суммирует и выводит результат";
    }

    public String version() {
        return "1.2.3.4.5";
    }

    @Override
    public void setInitParam(String initParam) throws Exception {
        this.initParam = initParam;
    }

    @Override
    public void execute(ChainContext chainContext) throws Exception {
        Source<String> stringSource =
                (Source<String>)
                        (Source<?>) chainContext.getSource("test.source");

        String sourceText = stringSource.getSource();
        System.out.println("Source text: " + sourceText);
        System.out.println("\tcount char source text: " + sourceText.length());
        System.out.println("Param text: " + initParam);
        System.out.println("\tcount char param text: " + initParam.length());
        System.out.println("Result text: " + sourceText + initParam);
        System.out.println("\tcount char result text: " + (sourceText + initParam).length());
    }

}
