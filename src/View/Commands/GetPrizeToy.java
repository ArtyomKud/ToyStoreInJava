package View.Commands;

import View.View;

public class GetPrizeToy extends Command{

    public GetPrizeToy(View view) {
        super(view);
    }
    @Override
    public String getDescription() {
        return "Получить призовую игрушку";
    }
    public void execute(){
        getView().getPrizeToy();

    }
}
