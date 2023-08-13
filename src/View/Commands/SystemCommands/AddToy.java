package View.Commands.SystemCommands;

import View.Commands.Command;
import View.View;

public class AddToy extends Command {
    private String description = "Добавить игрушку";
    public AddToy(View view) {
        super(view);
    }
    public void execute(){
        getView().addToy();

    }

}
