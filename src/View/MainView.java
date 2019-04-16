package src.View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainView extends Pane {

    public MainView() {
        super();

        VBox root = new VBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(10);

        Button constructorDif_but = new Button("Create difference");
        Button overview_but = new Button("View differences");
        treatButton(constructorDif_but, overview_but);

        root.getChildren().addAll(constructorDif_but, overview_but);
        getChildren().addAll(root);

        constructorDif_but.setOnMouseClicked(event -> {
            openWindow(new Compare_mainView(), 800, 250);
        });

        overview_but.setOnMouseClicked(event -> {
            openWindow(new OverviewView());
        });
    }

    private void treatButton(Button ... button) {
        for (Button but : button) {
            but.setPrefHeight(40);
            but.setPrefWidth(350);
            but.setFont(new Font(32));
        }
    } //приводит параметр Button к "стандарту" для этого меню

    public void openWindow(Pane newRoot) {
        openWindow(newRoot, -1, -1);
    }

    public void openWindow(Pane newRoot, double width, double height) {
        Stage stage = new Stage();
        Scene scene = new Scene(newRoot, width, height);
        stage.setScene(scene);
        stage.show();
    }
}
