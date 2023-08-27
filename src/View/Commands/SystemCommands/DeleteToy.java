package View.Commands.SystemCommands;

import View.Commands.Command;
import View.View;

public class DeleteToy extends Command {

    public DeleteToy(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Удалить игрушку";
    }
    public void execute(){
        getView().deleteToy();

    }
}
