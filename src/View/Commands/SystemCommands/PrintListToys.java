package View.Commands.SystemCommands;

import View.Commands.Command;
import View.View;

public class PrintListToys extends Command {
    public PrintListToys(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Вывести список игрушек";
    }
    public void execute(){
        getView().printListToys();

    }
}
