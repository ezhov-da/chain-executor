package ru.ezhov.chain.datasets.utils;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class InstructionReader {

    private static final String PATH_TO_INSTRUCTION_FOLDER_RESOURCE = "/instructions/";
    private static final String EXTENSION_INSTRUCTION = ".txt";
    private String instructionName;

    public InstructionReader(String instructionName) {
        this.instructionName = instructionName;
    }

    public String read() {
        try (Scanner scanner =
                     new Scanner(
                             new BufferedInputStream(
                                     InstructionReader.class.getResourceAsStream(
                                             PATH_TO_INSTRUCTION_FOLDER_RESOURCE +
                                                     instructionName +
                                                     EXTENSION_INSTRUCTION
                                     )
                             ),
                             "UTF-8"
                     )
        ) {
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }

            return stringBuilder.toString();
        }
    }
}
