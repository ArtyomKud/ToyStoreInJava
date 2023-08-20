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

    public int getId() {
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

    @Override
    public String toString(){
        StringBuilder str2 = new StringBuilder();
        str2.append("id");
        str2.append(getId());
        str2.append("\n");
        str2.append("Название: ");
        str2.append(getTitle());
        str2.append("\n");
        str2.append("Количество: ");
        str2.append(getQuantity());
        str2.append("\n");
        str2.append("Процент выпадения: ");
        str2.append(getFrequencyOfLoss());

        return str2.toString();
    }
}
