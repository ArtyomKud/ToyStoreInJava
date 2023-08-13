package View.Commands;

import View.View;

public class HoldRaffleToys extends Command{

    public HoldRaffleToys(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Провести розыгрыш игрушек";
    }
    public void execute(){
        getView().holdRaffleToys();

    }
}
