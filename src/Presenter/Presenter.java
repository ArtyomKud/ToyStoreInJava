package Presenter;

import Model.Model;
import View.View;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view){
        this.model = model;
        this.view = view;
        view.setPresenter(this);
    }
    public String addToy(String title, int quantity, int frequencyOfLoss){
        Boolean flag;
        flag = model.addToy(title,quantity, frequencyOfLoss);
        if(flag){
            return "Игрушка успешно добавлена";
        }
        else {
            return "Игрушка с таким названием уже существует";
        }

    }

    public String changeTheFrequencyOfDropout(String title, int frequencyOfLoss){
        Boolean flag;
        flag = model.changeTheFrequencyOfDropout(title, frequencyOfLoss);
        if(flag){
            return "Частота выпадения игрушки изменена";
        }
        else {
            return "Игрушка с таким названием не найдена";
        }
    }

    public String holdRaffleToys(){
        String nameToy;
        nameToy = model.holdRaffleToys();
        if(nameToy.equals("Игрушек для розыгрыша нет")){
            return nameToy;
        }
        else if(nameToy.length()!= 0){
            return "Вы выиграли игрушку "+nameToy;
        }
        else {
            return "Вы ничего не выиграли =(";
        }

    }
    public void checkJsonFile(){
        model.checkListToysFile();
    }


    public String printListToys() {
        return model.printListToys();
    }

    public void saveListToys() {
        model.saveListToys();

    }

    public String deleteToy(String name) {
       return model.deleteToy(name);
    }
}
