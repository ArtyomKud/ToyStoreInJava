package View.Commands;

import View.View;


public class Command {
    private String description;
    private View view;

    public Command(View view){
        this.view = view;
    }
    public View getView(){
        return view;
    }

    public String getDescription() {
        return description;
    }

    public void execute(){

    }
}
