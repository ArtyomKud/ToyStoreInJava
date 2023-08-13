package View.Commands.SystemCommands;

import View.Commands.Command;
import View.View;

public class ChangeTheFrequencyOfDropout extends Command {
    private String description = "Изменить частоту выпадения игрушки";
    public ChangeTheFrequencyOfDropout(View view) {
        super(view);
    }
    public void execute(){
        getView().changeTheFrequencyOfDropout();

    }

}
