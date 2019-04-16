package src.ModelHex;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class HexsModelView extends Pane {

    private HexsModel hexsModel;

    private VBox root = new VBox();
    private ScrollPane scrollPane = new ScrollPane();
    private FlowPane flowPane = new FlowPane();

    public HexsModelView(Hexs hexs) {
        Label file_lab = new Label(hexs.getFileName());
        Button addChildren_but = new Button("Show hexs!");

        hexsModel = new HexsModel(hexs);

        /*scrollPane.setPrefHeight(600);
        scrollPane.setFitToWidth(true);*/
        scrollPane.setPrefHeight(100);

        scrollPane.setContent(content_root);

        root.getChildren().addAll(file_lab, scrollPane, addChildren_but);
        getChildren().addAll(root);

        addChildren_but.setOnMouseClicked(event -> {
            addChildren();
        });

    }

    private static final double SIZE_CELL = 30;
    private int row_size = 8;
    private Pane content_root = new Pane();

    private void addChildren() {
        ArrayList<HexModel> hexModels_list = hexsModel.getHexModels_list();

        content_root.setPrefWidth(row_size * SIZE_CELL + 10);
        content_root.setPrefHeight((int)hexModels_list.size() / row_size);

        for(int i = 0; i < hexModels_list.size(); i++) {
            HexModelView hexView = new HexModelView(hexModels_list.get(i));
            content_root.getChildren().addAll(hexView);
        }

        repaint();
    }

    public void repaint() {
        ObservableList<Node> hexModels_list = content_root.getChildren();

        content_root.setPrefWidth(row_size * SIZE_CELL + 10);
        content_root.setPrefHeight((int)hexModels_list.size() / row_size);

        for(int i = 0; i < hexModels_list.size(); i++) {
            Node hexView = hexModels_list.get(i);

            int column = i % row_size;
            int row = (int) i / row_size;
            hexView.setTranslateX(column * SIZE_CELL);
            hexView.setTranslateY(row * SIZE_CELL);
        }
    }

    public void repaint(int row_size) {
        this.row_size = row_size;

        repaint();
    }

    public HexsModel getHexsModel() {
        return hexsModel;
    }
}
