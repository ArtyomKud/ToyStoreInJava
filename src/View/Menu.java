package View;

import View.Commands.*;
import View.Commands.SystemCommands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private View view;
    private List<Command> menu;
    private List<Command> systemMenu;

    public Menu(View view){
        menu = new ArrayList<>();
        systemMenu = new ArrayList<>();
        menu.add(new HoldRaffleToys(view));
        menu.add(new GetPrizeToy(view));
        menu.add(new SystemSettings(view));
        menu.add(new Exit(view));
        systemMenu.add(new AddToy(view));
        systemMenu.add(new ChangeTheFrequencyOfDropout(view));
        systemMenu.add(new PrintListToys(view));
        systemMenu.add(new DeleteToy(view));
        systemMenu.add(new ExitSystemMenu(view));
    }





    public StringBuilder getListCommands(){
        StringBuilder listCommands = new StringBuilder();
        if(menu.size() == 0){

            StringBuilder nonCommsnds = new StringBuilder("Команд не обнаружено");
            return nonCommsnds;
        }

        for (int i = 0; i < menu.size(); i++){
            listCommands.append(i);
            listCommands.append("-");
            listCommands.append(menu.get(i).getDescription());
            listCommands.append("\n");
        }
        return listCommands;
    }

    public StringBuilder getListSystemCommands(){
        StringBuilder listSystemCommands = new StringBuilder();
        if(systemMenu.size() == 0){

            StringBuilder nonSystemCommsnds = new StringBuilder("Команд не обнаружено");
            return nonSystemCommsnds;
        }

        for (int i = 0; i < systemMenu.size(); i++){
            listSystemCommands.append(i);
            listSystemCommands.append("-");
            listSystemCommands.append(systemMenu.get(i).getDescription());
            listSystemCommands.append("\n");
        }
        return listSystemCommands;
    }

    public int getSizeCommands() {

        return menu.size();
    }

    public int getSizeSystemCommands() {

        return systemMenu.size();
    }

    void executeCommands(int choice) {
        menu.get(choice).execute();
    }
    void executeSystemCommands(int choice) {
        systemMenu.get(choice).execute();
    }

}
