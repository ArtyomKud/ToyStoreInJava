package View.Commands.SystemCommands;

import View.Commands.Command;
import View.View;

public class ChangeTheFrequencyOfDropout extends Command {

    public ChangeTheFrequencyOfDropout(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Изменить частоту выпадения игрушки";
    }
    public void execute(){
        getView().changeTheFrequencyOfDropout();

    }

}
