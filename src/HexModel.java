package src;

import java.util.ArrayList;

public class HexModel {

    private int value;
    private String hex;
    private char text;

    private Status status;
    private boolean fake;

    public HexModel(int value) {
        this.value = value;
        hex = Hexs.hex(value);
        text = Hexs.text(value);
        status = Status.NotVerified;
        fake = false;
    }

    public int getValue() {
        return value;
    }

    public String getHex() {
        return hex;
    }

    public char getText() {
        return text;
    }

    public void setFake() {
        fake = true;
    }

    public boolean isFake() {
        return fake;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        inform();
    }

    private ArrayList<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void inform() {
        for (Subscriber subscriber : subscribers) {
            subscriber.notified();
        }
    }

    public boolean equalValue(HexModel hexModel2) {
        return value == hexModel2.value;
    }
}
