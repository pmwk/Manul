package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import src.View.MainView;


/*
* Hexs - содржит список Integer значений
* HexModel - это одно значение, которое сразу содержит 16-ое отображение + конвертацию в текст
* HexsModel - список HexModel*/

public class Main extends Application{

    public static void main(String[] args) {
        //Hexs hexs = new Hexs(new File("/home/kanumba/.PlayOnLinux/wineprefix/EdtorHeroes3/drive_c/EditorHeroes32/Maps/test1.h3m"));
        //hexs.printAll();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Hexs hexs = new Hexs(new File("/home/kanumba/.PlayOnLinux/wineprefix/EdtorHeroes3/drive_c/EditorHeroes32/Maps/test1.h3m"));

        //HexsModelView hexsModelView = new HexsModelView(hexs);

        //root.addHexsModelView(hexsModelView);

        MainView root = new MainView();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F2) {
                System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576 + "mb");
            }
        });
    }
}
