package View.Commands;

import View.View;

public class Exit extends Command{

    public Exit(View view) {
        super(view);
    }

    @Override
    public String getDescription() {
        return "Выход";
    }

    public void execute(){
        getView().exit();

    }
}
