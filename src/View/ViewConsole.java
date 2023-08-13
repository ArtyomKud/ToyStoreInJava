package View;

import Presenter.Presenter;

import java.util.Scanner;

public class ViewConsole extends View{
    private Boolean flag;
    private Boolean flag1;
    private Scanner scanner;

    public ViewConsole(){
        scanner = new Scanner(System.in);
        flag = true;
        flag1 = true;
        this.menu = new Menu(this);
    }

    @Override
    public void start() {
        while (flag) {
            System.out.println(menu.getListCommands());
            String choice = scanner.nextLine();
            if (checkCommand(choice)) {
                menu.executeCommands(Integer.parseInt(choice));
            }
            else {
                System.out.println("Неверный номер пункта");
            }


        }



    }

    @Override
    public void setPresenter (Presenter presenter){
        this.presenter = presenter;
    }

    public Boolean checkCommand(String text){
        return (text.matches("[0-9]") && Integer.parseInt(text) <= (menu.getSizeCommands()-1)&& Integer.parseInt(text) >=0);
    }
    public Boolean checkSystemCommand(String text){
        return (text.matches("[0-9]") && Integer.parseInt(text) <= (menu.getSizeSystemCommands()-1)&& Integer.parseInt(text) >=0);
    }

    @Override
    public void addToy(){

    }

    @Override
    public void changeTheFrequencyOfDropout() {
    }

    @Override
    public void holdRaffleToys() {
    }

    @Override
    public void getPrizeToy() {
    }

    @Override
    public void systemSettings() {
        while (flag1) {
            System.out.println(menu.getListSystemCommands());
            String choice = scanner.nextLine();
            if (checkSystemCommand(choice)) {
                menu.executeSystemCommands(Integer.parseInt(choice));
            } else {
                System.out.println("Неверный номер пункта");
            }
        }
    }

    @Override
    public void exit() {
        flag = false;
    }
    @Override
    public void exitSystemMenu() {
        flag1 = false;
    }






}


