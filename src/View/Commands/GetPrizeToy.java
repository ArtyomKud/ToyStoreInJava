package View.Commands;

import View.View;

public class GetPrizeToy extends Command{
    private String description = "Получить призовую игрушку";
    public GetPrizeToy(View view) {
        super(view);
    }
    private void execute(){
        getView().getPrizeToy();

    }
}
