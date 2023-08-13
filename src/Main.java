import Model.Model;
import Presenter.Presenter;
import View.View;
import View.ViewConsole;

public class Main {
    public static void main(String[] args) {
        View view = new ViewConsole();
        Model model = new Model();
        Presenter presenter = new Presenter(model, view);

        view.start();

    }



}
