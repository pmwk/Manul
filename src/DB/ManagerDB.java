package src.DB;

import src.DB.Models.Dementor;

import java.sql.SQLException;

public class ManagerDB {

    public static void addDementor(Dementor dementor) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO DEMENTOR (hash, fileName, path, description)\n" +
                " VALUES ()");
        sql.append("'" + dementor.getHash() + "', ");
        sql.append("'" + dementor.getName() + "', ");
        sql.append("'" + dementor.getPath() + "', ");
        sql.append("'" + dementor.getDescription() + "');");

        DB.execute(sql.toString());
    }

}
