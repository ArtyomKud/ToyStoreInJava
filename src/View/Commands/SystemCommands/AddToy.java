package View.Commands.SystemCommands;

import View.Commands.Command;
import View.View;

public class AddToy extends Command {

    public AddToy(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Добавить игрушку";
    }
    public void execute(){
        getView().addToy();

    }

}
