package ru.ezhov.chain.sources.db;

import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.chain.plugin.exception.SourceInitializeException;
import ru.ezhov.chain.plugin.exception.SourcePluginException;
import ru.ezhov.chain.sources.utils.InstructionReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionSourcePlugin implements SourcePlugin {

    private String url;
    private String clazz;
    private String username;
    private String password;

    private Connection connection;


    @Override
    public void init(String param) throws SourceInitializeException {
        String[] strings = param.split("\n");
        url = strings[0];
        clazz = strings[1];
        username = strings[2];
        password = strings[3];
    }

    @Override
    public Object getSource() throws SourcePluginException {
        try {
            Class.forName(clazz);
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            SourcePluginException sourcePluginException = new SourcePluginException(e.getMessage());
            sourcePluginException.addSuppressed(e);
            throw sourcePluginException;
        }
    }

    @Override
    public void preDestroy() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String instruction() {
        return new InstructionReader(getClass().getCanonicalName()).read();
    }

    @Override
    public String version() {
        return "0.1";
    }
}
