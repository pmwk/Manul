package src.View;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import src.DB.DBAPI;
import src.DB.Models.Dementor;

import java.sql.SQLException;
import java.util.ArrayList;

public class OverviewView extends Pane {

    private final static double HEIGHT_BUTTON_OPEN = 30;
    private final static double WIDTH_LIST_DEMENTORS = 250;

    private HBox root;
    private ScrollPane listDementors_sp;
    private VBox listDementors;
    private Pane main_root = new Pane();

    public OverviewView() {
        super();

        root = new HBox();

        VBox listDementors_root = new VBox();
        listDementors_root.setPrefWidth(WIDTH_LIST_DEMENTORS);
        listDementors_root.setMaxWidth(WIDTH_LIST_DEMENTORS);

        listDementors_sp = new ScrollPane();
        listDementors = new VBox();
        setDementors();
        listDementors_sp.setContent(listDementors);

        HBox buttons_listDementors_root = new HBox();
        buttons_listDementors_root.setMaxHeight(30);
        buttons_listDementors_root.setPrefHeight(30);

        Button openDementors_but = new Button("Open");

        buttons_listDementors_root.getChildren().addAll(openDementors_but);

        listDementors_root.getChildren().addAll(listDementors_sp, buttons_listDementors_root);

        root.getChildren().addAll(listDementors_root, main_root);
        getChildren().addAll(root);

        chain();

        openDementors_but.setOnMouseClicked(event -> {
            if (dementorView_icon_focus != null) {
                main_root.getChildren().clear();
                main_root.getChildren().addAll(new DementorView(dementorView_icon_focus.getDementor()));
            }
        });
    }

    private void chain() {
        root.prefHeightProperty().bind(this.heightProperty());

        listDementors_sp.prefHeightProperty().bind(root.prefHeightProperty().add(-HEIGHT_BUTTON_OPEN));

        /*root.prefHeightProperty().addListener((ov, oldValue, newValue) -> {
            System.out.println(newValue.doubleValue());
            listDementors_sp.setPrefHeight(newValue.doubleValue());
        });*/
    }

    private DementorView_Icon dementorView_icon_focus;
    private void setDementors() {
        try {
            ArrayList<Dementor> dementors = DBAPI.getDementors();
            for (Dementor dementor : dementors) {
                DementorView_Icon dementorView = new DementorView_Icon(dementor);
                listDementors.getChildren().addAll(dementorView);

                dementorView.setOnMouseClicked(event -> {
                    if (dementorView != dementorView_icon_focus) {
                        if (dementorView_icon_focus != null) {
                            dementorView_icon_focus.setFocus(false);
                        }
                        dementorView.setFocus(true);
                        dementorView_icon_focus = dementorView;
                    }
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
