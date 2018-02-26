package ru.ezhov.chain.links.db;

import ru.ezhov.chain.links.utils.InstructionReader;
import ru.ezhov.chain.plugin.DataSetPlugin;
import ru.ezhov.chain.plugin.LinkPlugin;
import ru.ezhov.chain.plugin.SourcePlugin;
import ru.ezhov.chain.plugin.exception.DataSetPluginException;
import ru.ezhov.chain.plugin.exception.LinkInitializeException;
import ru.ezhov.chain.plugin.exception.LinkJoinException;
import ru.ezhov.chain.plugin.exception.SourcePluginException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PrintResultSetToConsole implements LinkPlugin {
    @Override
    public void init(String param) throws LinkInitializeException {

    }

    @Override
    public void join(SourcePlugin[] sources, DataSetPlugin[] dataSets)
            throws
            LinkJoinException,
            SourcePluginException,
            DataSetPluginException {
        try {
            ResultSet resultSet = (ResultSet) dataSets[0].getDataSet();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSetMetaData.getCatalogName(i));
            }

            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            throw new LinkJoinException(e);
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
