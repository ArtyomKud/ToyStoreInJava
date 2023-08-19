package Model;

import Model.Toys.Toy;

import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Toy> toys = new ArrayList<>();


    public Boolean addToy(String title, int quantity, int frequencyOfLoss){

        if(!checkToy(title)) {
            toys.add(new Toy(title,quantity,frequencyOfLoss));
            if(checkToy(title)){
                return true;
            }
        }

        return false;

    }

    private Boolean checkToy(String title){
        if(toys.size() == 0){
            return false;
        }

        for (Toy toy: toys) {
            if (toy.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }
}
