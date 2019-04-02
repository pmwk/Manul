package src;

import javafx.scene.layout.FlowPane;

public class HexsModelView extends FlowPane {

    public HexsModelView(Hexs hexs) {
        HexsModel hexsModel = new HexsModel(hexs);

        setPrefWidth(900);

        for (HexModel hexModel : hexsModel.getHexModels_list()) {
            HexModelView hexModelView = new HexModelView(hexModel);
            getChildren().addAll(hexModelView);
        }
    }
}
