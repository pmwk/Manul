package src.DB;

import javafx.scene.layout.Pane;
import src.DB.Models.Chain;
import src.DB.Models.Dementor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBAPI {

    public static ArrayList<Dementor> getDementors() throws SQLException {
        ResultSet rs = DB.executeQuery("SELECT * FROM DEMENTOR;");

        ArrayList<Dementor> dementors = new ArrayList<>();
        while(rs.next()) {
            Dementor dementor = new Dementor(rs.getInt("id"),
                    rs.getString("hash"),
                    rs.getString("fileName"),
                    rs.getString("path"),
                    rs.getString("dateCreate"),
                    rs.getString("description"));
            dementors.add(dementor);
        }
        DB.closeLastConnection();
        return dementors;
    }

    public static ArrayList<Chain> getChainsByIdDementor(int id) throws SQLException {
        ResultSet rs = DB.executeQuery("SELECT *\n" +
                "FROM CHAIN\n" +
                "WHERE id = (SELECT DISTINCT idChain " +
                "FROM CHAIN_DIFFERENCES  " +
                "WHERE parent =" + id + " OR child=" + id + ");");
        ArrayList<Chain> chains = new ArrayList<>();
        while(rs.next()) {
            Chain chain = new Chain(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("dateCreate"));
            chains.add(chain);
        }

        DB.closeLastConnection();

        return chains;
    }

    public static ArrayList<Dementor> getWasComparedById(int id) throws SQLException {
        ResultSet rs = DB.executeQuery("SELECT DISTINCT id\n" +
                "  FROM DIFFERENCES\n" +
                "  WHERE sourceDementor = " + id + ";");

        ArrayList<Dementor> dementors = new ArrayList<>();
        while(rs.next()) {
            Dementor dementor = new Dementor();
            dementor.setId(rs.getInt("id"));
            dementors.add(dementor);
        }
        DB.closeLastConnection();

        return dementors;
    } //список тех demontors, с которыми сравнивали

    public static ArrayList<Dementor> getComparedById(int id) throws SQLException {
        ResultSet rs = DB.executeQuery("SELECT DISTINCT id\n" +
                "  FROM DIFFERENCES\n" +
                "  WHERE rabbitDementor = " + id + ";");

        ArrayList<Dementor> dementors = new ArrayList<>();
        while(rs.next()) {
            Dementor dementor = new Dementor();
            dementor.setId(rs.getInt("id"));
            dementors.add(dementor);
        }
        DB.closeLastConnection();

        return dementors;
    } //список тех demontors, с которыми сравнивался id

}
