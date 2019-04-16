package src.View;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import src.DB.Models.Dementor;

public class DementorView_Icon extends Pane {

    private Dementor dementor;

    public DementorView_Icon(Dementor dementor) {
        super();

        this.dementor = dementor;

        VBox root = new VBox();

        Label name_lab = new Label(dementor.getName());
        name_lab.setFont(new Font(26));
        Label date_lab = new Label(dementor.getDate());
        date_lab.setStyle("-fx-font-style: italic;" +
                "-fx-font-size: 18");

        root.getChildren().addAll(name_lab, date_lab);
        getChildren().addAll(root);

    }


    public Dementor getDementor() {
        return dementor;
    }

    public void setFocus(boolean focus) {
        if (focus) {
            setBackgroundColor("LightGray");
        } else {
            setBackgroundColor("none");
        }
    }

    private void setBackgroundColor(String color) {
        setStyle("-fx-background-color: " + color + ";");
    }
}
