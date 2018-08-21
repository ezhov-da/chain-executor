package ru.ezhov.chain.sources.db;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DbConnectionSourcePluginTest {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String CLAZZ = "org.postgresql.Driver";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";


    @Test
    public void initOk() throws Exception {
    }

    private String getInitParam() {
        return URL + "\n" +
                CLAZZ + "\n" +
                USERNAME + "\n" +
                PASSWORD;
    }

    @Test
    public void getSourceOk() throws Exception {
        DbConnectionSourcePlugin dbConnectionSourcePlugin = new DbConnectionSourcePlugin();
        dbConnectionSourcePlugin.init(getInitParam());
        try (Connection connection = (Connection) dbConnectionSourcePlugin.getSource();) {
            assertNotNull(connection);
            String schema = connection.getSchema();
            System.out.println("test schema: " + schema);
        }
    }

    @Test
    public void preDestroyOk() throws Exception {
    }

    @Test
    public void instructionOk() throws Exception {
    }

    @Test
    public void versionOk() throws Exception {
    }

}