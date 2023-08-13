package View.Commands;

import View.View;

public class SystemSettings extends Command{

    public SystemSettings(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Системные настройки";
    }
    public void execute(){
        getView().systemSettings();

    }
}
