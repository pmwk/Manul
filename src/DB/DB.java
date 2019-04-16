package src.DB;

import java.sql.*;

public class DB {

    private static final String URL = "jdbc:sqlite:/home/kanumba/Projects/CompareHEXs/src/Resource/database";

    public static Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        return connection;
    }

    public static void execute(String sql) throws SQLException {
        Connection connection = connect();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        connection.close();
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection connection = connect();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        lastConnection = connection;
        return rs;
    }

    private static Connection lastConnection;
    public static void closeLastConnection() throws SQLException {
        if (lastConnection != null) {
            lastConnection.close();
            lastConnection = null;
        }
    }

}
