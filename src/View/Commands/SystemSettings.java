package View.Commands;

import View.View;

public class SystemSettings extends Command{
    private String description = "Системные настройки";
    public SystemSettings(View view) {
        super(view);
    }
    private void execute(){
        getView().systemSettings();

    }
}