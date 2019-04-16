package src.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import src.HandlersHex.PrinterHexsModel;
import src.ModelHex.Hexs;
import src.ModelHex.HexsModel;
import src.ModelHex.HexsModelView;

import java.io.File;
import java.util.ArrayList;

public class Compare_mainView extends Pane {

    private VBox root = new VBox();
    private HBox hexs_root = new HBox();
    private VBox buttons_root = new VBox();
    private HBox buttonsUp_root = new HBox();

    public Compare_mainView() {
        super();

        Button openNewFile_but = new Button("Add file");
        Button compare_but = new Button("Compare");

        VBox printCompares_root = new VBox();
        Button printCompares_but = new Button("Print compare");

        HBox printCompares_rb_root = new HBox();
        RadioButton printAddress_Value_rb = new RadioButton("Address: value");
        RadioButton printAddress_Value_Original_rb = new RadioButton("Address: value (original)");
        printCompares_rb_root.getChildren().addAll(printAddress_Value_rb, printAddress_Value_Original_rb);
        printCompares_root.getChildren().addAll(printCompares_but, printCompares_rb_root);

        HBox buttonsDB_root = new HBox();

        Button saveDementor_but = new Button("Сохранить данные в базу");
        Button createChain_but = new Button("Сохранить chain в базу");

        buttonsDB_root.getChildren().addAll(saveDementor_but, createChain_but);

        buttonsUp_root.getChildren().addAll(openNewFile_but, compare_but, printCompares_root);
        buttons_root.getChildren().addAll(buttonsUp_root, buttonsDB_root);
        root.getChildren().addAll(hexs_root, buttons_root);
        getChildren().addAll(root);

        openNewFile_but.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                if (!file.isDirectory()) {
                    Hexs hexs = new Hexs(file);
                    HexsModelView modelView = new HexsModelView(hexs);
                    addHexsModelView(modelView);
                }
            }
            System.out.println("open");
        });

        compare_but.setOnMouseClicked(event -> {
            HexsModel.compare(hexsModelViews.get(0).getHexsModel(), hexsModelViews.get(1).getHexsModel());
            System.out.println("compare");
        });

        printCompares_but.setOnMouseClicked(event -> {
            if (printAddress_Value_rb.isSelected()) {
                PrinterHexsModel.printAddress_Value_changed(hexsModelViews.get(1).getHexsModel());
            }

            if (printAddress_Value_Original_rb.isSelected()) {
                PrinterHexsModel.printAdress_Value_error_Original
                        (hexsModelViews.get(1).getHexsModel(), hexsModelViews.get(0).getHexsModel());
            }
        });

        saveDementor_but.setOnMouseClicked(event -> {
            openWindow(new SaveDementorsView(getHexsModels()));
        });
    }

    public ArrayList<HexsModel> getHexsModels() {
        ArrayList<HexsModel> hexsModels = new ArrayList<>();
        for (HexsModelView hexsModelView : hexsModelViews) {
            hexsModels.add(hexsModelView.getHexsModel());
        }
        return hexsModels;
    }

    private ArrayList<HexsModelView> hexsModelViews = new ArrayList<>();
    public void addHexsModelView (HexsModelView modelView) {
        hexs_root.getChildren().addAll(modelView);
        hexsModelViews.add(modelView);
    }

    private void openWindow(Pane newRoot) {
        openWindow(newRoot, -1, -1);
    }

    private void openWindow(Pane newRoot, double width, double height) {
        Stage stage = new Stage();
        Scene scene = new Scene(newRoot, width, height);
        stage.setScene(scene);
        stage.show();
    }

}
