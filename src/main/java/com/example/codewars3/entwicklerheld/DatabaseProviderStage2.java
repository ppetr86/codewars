package com.example.codewars3.entwicklerheld;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseProviderStage2 extends DatabaseProvider {

    @Override
    public void createVINTable(Connection connection) throws SQLException {
        // The naive solution. You can change it as you like
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE IF NOT EXISTS vindata (\n" +
                        " id INTEGER NOT NULL PRIMARY KEY,\n" +
                        " vin TEXT NOT NULL, \n" +
                        " data BLOB NOT NULL\n" +
                        ");"
        );
    }

    @Override
    public void insertVINData(Connection connection, String vin, byte[] data) throws SQLException {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public byte[] getVINData(Connection connection, String vin) throws SQLException {
        throw new RuntimeException("Not implemented yet");
    }
}
