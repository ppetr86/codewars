package com.example.entwicklerheld;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseProvider {

    public Connection createDatabase(File databaseFile) throws SQLException {
        String url = "jdbc:sqlite:" + databaseFile.getAbsolutePath();
        Connection c = DriverManager.getConnection(url);
        return c;
    }

    public void createVINTable(Connection connection) throws SQLException {
        String createQuery = "" +
                "CREATE TABLE IF NOT EXISTS vindata (" +
                "id INTEGER PRIMARY KEY," +
                "vin TEXT," +
                "data BLOB)";
        Statement statement = connection.createStatement();
        statement.execute(createQuery);

    }

    public void insertVINData(Connection connection, String vin, byte[] data) throws SQLException {
        if (vinIsInvalid(vin))
            throw new RuntimeException(String.format("The given vin %s is invalid", vin));

        String sql = "INSERT INTO vindata(vin, data) " +
                "VALUES(?, ?)";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, vin);
        pstmt.setBytes(2, data);
        pstmt.executeUpdate();
    }

    private boolean vinIsInvalid(String vin) {
        String[] letters = vin.split("");
        if (letters.length != 17)
            return true;
        for (String letter : letters) {
            if (letter.equals("O") || letter.equals("I") || letter.equals("Q"))
                return true;
        }
        return false;
    }

    public byte[] getVINData(Connection connection, String vin) throws SQLException {
        if (vin == null || vin.isEmpty())
            return null;
        String sql = "SELECT data FROM vindata where vin LIKE ? LIMIT 1";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, vin);
        ResultSet rs = pstmt.executeQuery();
        return rs.getBytes("data");
    }
}
