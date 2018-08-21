package ru.ezhov.chain.datasets.db;

import ru.ezhov.chain.datasets.utils.InstructionReader;
import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.chain.plugin.exception.DataSetInitializeException;
import ru.ezhov.chain.plugin.exception.DataSetPluginException;
import ru.ezhov.chain.plugin.exception.SourcePluginException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ResultSetFromSelect implements DataSetPlugin {
    private String query;
    private SourcePlugin sourcePluginConnection;
    private ResultSet resultSet;

    @Override
    public void init(String param, List<SourcePlugin> sources) throws DataSetInitializeException {
        query = param;
        sourcePluginConnection = sources.get(0);
    }

    @Override
    public Object getDataSet() throws DataSetPluginException {
        try {
            Connection connection = (Connection) sourcePluginConnection.getSource();
            try (Statement statement = connection.createStatement()) {
                resultSet = statement.executeQuery(query);
                return resultSet;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw new DataSetPluginException(e);
        }
    }

    @Override
    public void preDestroy() {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
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
