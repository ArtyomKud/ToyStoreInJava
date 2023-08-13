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


}
