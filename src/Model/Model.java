package Model;

import Model.Toys.Toy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    File listToys;
    String filePath = new File("").getAbsolutePath();
    String fileNameJsonListToys = "listToys.json";
    String fileNameJsonListWonToys = "listWonToys.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    List<Toy> toys = new ArrayList<>();
    Random random = new Random();
    String jsonString;


    public Boolean addToy(String title, int quantity, int frequencyOfLoss){

        if(!checkToy(title)) {
            toys.add(new Toy(title,quantity,frequencyOfLoss));
            if(checkToy(title)){
                return true;
            }
        }

        return false;

    }

    public Boolean changeTheFrequencyOfDropout(String title, int frequencyOfLoss){
        if(checkToy(title)) {
            for (Toy toy: toys) {
                toy.setFrequencyOfLoss(frequencyOfLoss);
                return true;

            }

        }
        return false;
    }

    public String holdRaffleToys(){
        int number;
        int summPercent = 0;
        int idWinToy;
        String nameWinToy = "";
        List<Integer> toysListTemp = new ArrayList<>();
        if(toys.size()==0){
            return "Игрушек для розыгрыша нет";
        }
        for (Toy toy: toys) {
            if(toy.getQuantity()!=0){
              summPercent = summPercent + toy.getFrequencyOfLoss();
            }
        }
        number = random.nextInt(summPercent+1);
        for (Toy toy: toys) {
            if(toy.getQuantity()!=0){
                for(int i = toy.getFrequencyOfLoss(); i > 0; i--){
                    toysListTemp.add(toy.getId());
                }
            }
        }
        idWinToy = toysListTemp.get(number);
        for (Toy toy: toys) {
            if(toy.getId()==idWinToy){
                int temp = toy.getQuantity()-1;
                toy.setQuantity(temp);
                nameWinToy = toy.getTitle();
                if(toy.getQuantity()==0){
                    toys.remove(toy);
                }
                break;
            }
        }
        return nameWinToy;

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

    public void checkJsonFile() {
        gson = new Gson();
        try {
            if(listToys.exists() && !listToys.isDirectory()){
                GsonBuilder builder = new GsonBuilder();
                gson = builder.create();
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(
                            new FileReader(fileNameJsonListToys));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                toys = (List<Toy>) gson.fromJson(bufferedReader, Toy.class);
            }
        } catch (NullPointerException e){

        }




    }


    public String printListToys() {
        StringBuilder str = new StringBuilder();
        if(toys.size()>0){
            for (Toy toy: toys) {
                str.append(toy.toString());
                str.append("\n");
            }
            return str.toString();
        }
        return "Списк игрушек пуст!";

    }
}
