package View.Commands;

import View.View;

public class Exit extends Command{
    private String description = "Выход";
    public Exit(View view) {
        super(view);
    }
    private void execute(){
        getView().exit();

    }
}
