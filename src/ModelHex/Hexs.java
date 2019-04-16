package src.ModelHex;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hexs {

    private String fileName;
    private String path;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }

    private ArrayList<Integer> values = new ArrayList<>();

    private Hexs() {

    }

    public Hexs(File file) throws Error {
        if (file.exists()) {
            fileName = file.getName();
            path = file.getAbsolutePath();

            try {
                InputStream is = new FileInputStream(file);

                int value;

                while ((value = is.read()) !=-1) {
                    values.add(value);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new Error(e.getCause().toString());
            } catch (IOException e) {
                e.printStackTrace();
                throw new Error(e.getCause().toString());
            }
        } else {
            throw new Error("Файл не сущесвтует");
        }
    }

    public void printAll() {
        int counter = 0;
        for (Integer value : values) {
            System.out.print(value + " ");
            counter++;
            if (counter == 16) {
                counter = 0;
                System.out.println();
            }
        }
    }

    public static String hex(int i) {
        return String.format("%02X", i);
    }

    public static char text(int i) {
        return text_sub(i, '.');
    }

    public static char text_sub(int i, char ch) {
        if (!Character.isISOControl(i)) {
            return (char) i;
        } else {
            return ch;
        }
    }
}
