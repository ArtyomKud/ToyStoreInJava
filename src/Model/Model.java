package Model;

import Model.Toys.Toy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Model {
    File listToys;
    String filePath = new File("").getAbsolutePath();
    String fileNameListToys = "listToys.txt";
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

    public void checkListToysFile() {
        List<String[]> list = new ArrayList<>();
        StringBuilder str3 = new StringBuilder();
        str3.append(filePath);
        str3.append("\\");
        str3.append(fileNameListToys);

        try {
            if(Files.exists(Paths.get(String.valueOf(str3))) && !Files.isDirectory(Paths.get(String.valueOf(str3)))){
                try(FileReader reader = new FileReader(String.valueOf(str3)))
                {
                    Scanner scanner = new Scanner(reader);
                    while (scanner.hasNextLine()){
                        list.add(scanner.nextLine().split(" "));
                    }


                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
                for (String[] str2: list) {
                    toys.add(new Toy(str2[2], Integer.parseInt(str2[4]), Integer.parseInt(str2[7])));
                }

            }
        } catch (NullPointerException e){
            e.getMessage();

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

    public void saveListToys(){
        StringBuilder str = new StringBuilder();
        if(toys.size()>0){
            for (Toy toy: toys) {
                str.append(toy.toString());
                str.append("\n");
            }

        }
        try(FileWriter writer = new FileWriter(fileNameListToys, false)) {
            writer.write(str.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String deleteToy(String name) {
        String answer;
        if(toys.size() == 0){
            return "Список игрушек пуст!";
        }

        for (Toy toy: toys) {
            if (toy.getTitle().equalsIgnoreCase(name)) {
                toys.remove(toy);
                return "Игрушка удалена";
            }
        }

        return "Ошибка, повторите попытку";
    }
}
