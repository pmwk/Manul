package src;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HexModelView extends Pane implements Subscriber {

    public final static double SIZE = 30;

    private HexModel hexModel;

    public HexModelView(HexModel hexModel) {
        this.hexModel = hexModel;

        Text value_lab = new Text(hexModel.getHex());
        value_lab.setTranslateX(5);
        value_lab.setTranslateY(15);

        setPrefSize(SIZE, SIZE);

        getChildren().addAll(value_lab);

        if (hexModel.isFake()) {
            Label fake_lab = new Label("!");
            fake_lab.setTranslateX(25);
            getChildren().addAll(fake_lab);
        }

        decorate();
    }

    private void decorate() {
        String color = "";
        switch(hexModel.getStatus()) {
            case New:
                color = "lightgreen";
                break;
            case Equaled:
                color = "white";
                break;
            case Changed:
                color = "indianred";
                break;
            case NotVerified:
                color = "grey";
                break;
        }
        setStyle("-fx-background-color: " + color + ";");
    }

    @Override
    public void notified() {
        decorate();
    }
}
