package src.ModelHex;

import src.Status;

import java.util.ArrayList;

public class HexsModel {

    private HexsModel () {

    }

    private Hexs hexs;
    private boolean isDementor = false;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return hexs.getFileName();
    }

    public String getAbsolutePath() {
        return hexs.getPath();
    }

    public boolean isDementor() {
        return isDementor;
    }

    public void setDementor(boolean b) {
        isDementor = b;
    }

    public ArrayList<HexModel> getHexModels_list() {
        return hexModels;
    }

    public ArrayList<HexModel> getHexModels_listClear() {
        ArrayList<HexModel> listClear = new ArrayList<>(hexModels);
        for (int i = 0; i < hexModels.size(); i++) {
            HexModel hexModel = hexModels.get(i);
            if (hexModel.isFake()) {
                hexModels.remove(i);
                i--;
            }
        }

        return listClear;
    }

    public void setHexModels(ArrayList<HexModel> hexModels) {
        this.hexModels = hexModels;
    }

    private ArrayList<HexModel> hexModels = new ArrayList<>();

    public HexsModel(Hexs hexs) {
        this.hexs = hexs;
        ArrayList<Integer> values_hex = hexs.getValues();

        for (Integer value : values_hex) {
            hexModels.add(new HexModel(value));
        }
    }

    public static void compare(HexsModel hexsModel1, HexsModel hexsModel2) {
        ArrayList<HexModel> hexModels1 = hexsModel1.getHexModels_listClear();
        ArrayList<HexModel> hexModels2 = hexsModel2.getHexModels_list();
        for (int i = 0; i < hexModels2.size(); i++) {
            if (i >= hexModels1.size()) {
                for (; i < hexModels2.size(); i++) {
                    hexModels2.get(i).setStatus(Status.New);
                } //если у 1-ого списка закончились элементы, то на втором проставляем, что оставшиеся элементы новые
            } else {
                if (hexModels1.get(i).equalValue(hexModels2.get(i))) {
                    hexModels2.get(i).setStatus(Status.Equaled);
                } else {
                    hexModels2.get(i).setStatus(Status.Changed);
                }
            }
        }
    } //первый остаётся красивым, 2 - в нём изменятся статусы
}
