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


}
