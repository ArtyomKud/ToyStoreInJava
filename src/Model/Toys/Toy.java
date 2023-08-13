package Model.Toys;

import java.io.Serializable;

public class Toy implements Serializable {
    private static int id;
    private String title;
    private int quantity;
    private int frequencyOfLoss;

    public Toy(String title, int quantity, int frequencyOfLoss){
        this.id++;
        this.title = title;
        this.quantity = quantity;
        this.frequencyOfLoss = frequencyOfLoss;
    }

    public static int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getFrequencyOfLoss() {
        return frequencyOfLoss;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFrequencyOfLoss(int frequencyOfLoss) {
        this.frequencyOfLoss = frequencyOfLoss;
    }
}
