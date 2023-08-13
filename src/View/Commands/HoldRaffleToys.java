package View.Commands;

import View.View;

public class HoldRaffleToys extends Command{
    private String description = "Провести розыгрыш игрушек";
    public HoldRaffleToys(View view) {
        super(view);
    }
    private void execute(){
        getView().holdRaffleToys();

    }
}
