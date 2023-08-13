package View.Commands.SystemCommands;

import View.Commands.Command;
import View.View;

public class ExitSystemMenu extends Command {
    public ExitSystemMenu(View view) {
        super(view);
    }

    @Override
    public String getDescription() {
        return "Выйти из меню системных настроек";
    }

    public void execute(){
        getView().exitSystemMenu();

    }
}
