package src.HandlersHex;

import src.ModelHex.HexModel;
import src.ModelHex.HexsModel;

import java.util.ArrayList;

public class PrinterHexsModel {

    public static void printAddress_Value_changed(HexsModel hexsModel) {
        ArrayList<HexModel> list = hexsModel.getHexModels_list();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isChanged()) {
                System.out.println(i + ": " + list.get(i).getHex());
            }
        }
    }

    public static void printAdress_Value_error_Original (HexsModel hexsModel, HexsModel original) {
        ArrayList<HexModel> list = hexsModel.getHexModels_list();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isChanged()) {
                System.out.println(i + ": " + list.get(i).getHex() + "(" +
                        original.getHexModels_list().get(i).getHex() + ")");
            }
        }
    }

}
