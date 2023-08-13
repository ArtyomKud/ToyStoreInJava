package View.Commands.SystemCommands;

import View.Commands.Command;
import View.View;

public class СhangeTheFrequencyOfDropout extends Command {
    private String description = "Изменить частоту выпадения игрушки";
    public СhangeTheFrequencyOfDropout(View view) {
        super(view);
    }
    private void execute(){
        getView().changeTheFrequencyOfDropout();

    }

}
