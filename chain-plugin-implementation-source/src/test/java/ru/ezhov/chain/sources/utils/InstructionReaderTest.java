package ru.ezhov.chain.sources.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionReaderTest {
    @Test
    public void read() throws Exception {
        InstructionReader instructionReader = new InstructionReader("DbConnectionSourcePlugin");
        String s = instructionReader.read();
        assertNotNull(s);
    }

}