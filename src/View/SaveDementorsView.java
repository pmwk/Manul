package src.View;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import src.Catalog;
import src.DB.Models.Dementor;
import src.ModelHex.HexsModel;

import java.io.File;
import java.util.ArrayList;

public class SaveDementorsView extends Pane {

    private VBox root = new VBox();
    private VBox hexsModel_root = new VBox();
    private ArrayList<HexsModel> models;

    public SaveDementorsView(ArrayList<HexsModel> models) {
        super();

        this.models = models;

        ScrollPane hexsModel_sp = new ScrollPane();
        hexsModel_sp.setContent(hexsModel_root);
        addHexsModel();

        root.getChildren().addAll(hexsModel_sp);

        getChildren().addAll(root);
    }

    private ArrayList<rowHexsModel> listPrepareModels = new ArrayList<>();
    private void addHexsModel() {
        for (HexsModel hexsModel : models) {
            rowHexsModel row = new rowHexsModel(hexsModel);
            listPrepareModels.add(row);
            hexsModel_root.getChildren().addAll(row);
        }
    }


    class rowHexsModel extends Pane {

        private HexsModel hexsModel;
        private boolean isBD;
        private String hash;
        private String path;
        private String name;

        private HBox root = new HBox();
        private Label hash_lab = new Label();
        private Label path_lab = new Label();
        private Label name_lab = new Label();

        private CheckBox BD_cb = new CheckBox("add BD");
        private CheckBox copy_cb = new CheckBox("copy and save");

        public rowHexsModel(HexsModel hexsModel) {

            this.hexsModel = hexsModel;

            VBox title_root = new VBox();

            HBox path_root = new HBox();
            path_root.getChildren().addAll(path_lab, name_lab);
            title_root.getChildren().addAll(hash_lab, path_root);

            Button desc_but = new Button("Добавить описание");

            HBox option_root = new HBox();

            option_root.getChildren().addAll(BD_cb, copy_cb);

            root.getChildren().addAll(title_root, desc_but, option_root);

            getChildren().addAll(root);
            init();
        }

        private void init() {
            hash = Catalog.getHash(new File(hexsModel.getAbsolutePath()));


        }

        public Dementor getDementor() {
            return null;
        }
    }
}
