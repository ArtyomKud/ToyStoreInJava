package View.Commands;

import View.View;


public abstract class Command {
    private View view;

    public Command(View view){
        this.view = view;
    }
    public View getView(){
        return view;
    }

    public abstract String getDescription();

    public void execute(){

    }
}
