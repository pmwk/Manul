package src.View;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import src.DB.DBAPI;
import src.DB.Models.Chain;
import src.DB.Models.Dementor;

import java.sql.SQLException;
import java.util.ArrayList;

public class DementorView extends Pane {

    private Dementor dementor;

    private VBox root = new VBox();
    private VBox header = new VBox();
    private VBox chain_root = new VBox();
    private VBox toWasCompared_root = new VBox();
    private VBox toCompare_root = new VBox();


    public DementorView(Dementor dementor) {
        this.dementor = dementor;

        createHeader();
        createChainRoot();
        createToWasComapred();
        createToCompare();

        root.getChildren().addAll(header, chain_root, toWasCompared_root, toCompare_root);
        getChildren().addAll(root);
    }

    private void createToWasComapred() {
        HBox up_root = new HBox();
        Label title_lab = new Label("Был сравнён с: ");
        ComboBox<Dementor> wasComared_cb = new ComboBox<>();
        up_root.getChildren().addAll(title_lab, wasComared_cb);

        ScrollPane result_sp = new ScrollPane();
        Label result_lab = new Label();
        result_lab.setWrapText(true);
        result_sp.setContent(result_lab);

        toWasCompared_root.getChildren().addAll(up_root, result_sp);

        try {
            ArrayList<Dementor> dementors = DBAPI.getWasComparedById(dementor.getId());
            wasComared_cb.setItems(FXCollections.observableList(dementors));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createToCompare() {
        HBox up_root = new HBox();
        Label title_lab = new Label("Сравнивался с: ");
        ComboBox<Dementor> wasComared_cb = new ComboBox<>();
        up_root.getChildren().addAll(title_lab, wasComared_cb);

        ScrollPane result_sp = new ScrollPane();
        Label result_lab = new Label();
        result_lab.setWrapText(true);
        result_sp.setContent(result_lab);

        toCompare_root.getChildren().addAll(up_root, result_sp);

        try {
            ArrayList<Dementor> dementors = DBAPI.getComparedById(dementor.getId());
            wasComared_cb.setItems(FXCollections.observableList(dementors));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createChainRoot() {
        HBox up_root = new HBox();
        Label title_lab = new Label("Участвует в цепях: ");
        ComboBox<Chain> chains_cb = new ComboBox<>();
        Button open_but = new Button("Открыть эту цепь");
        up_root.getChildren().addAll(title_lab, chains_cb, open_but);


        chain_root.getChildren().addAll(up_root);

        try {
            ArrayList<Chain> chains = DBAPI.getChainsByIdDementor(dementor.getId());
            chains_cb.setItems(FXCollections.observableList(chains));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void createHeader() {
        header.setSpacing(3);
        HBox up_root = new HBox();
        up_root.setSpacing(10);
        Label id_lab = new Label(String.valueOf(dementor.getId()));
        Label hash_lab = new Label(dementor.getHash());
        Label dateCreate_lab = new Label(dementor.getDate());
        dateCreate_lab.setStyle("-fx-font-style: italic;");
        up_root.getChildren().addAll(id_lab, hash_lab, dateCreate_lab);

        HBox path_root = new HBox();
        path_root.setSpacing(10);
        Label name_lab = new Label(dementor.getName());
        Label path_lab = new Label(dementor.getPath());
        path_root.getChildren().addAll(path_lab, name_lab);

        Label description_lab = new Label(dementor.getDescription());

        header.getChildren().addAll(up_root, path_root, description_lab);
    }

}
