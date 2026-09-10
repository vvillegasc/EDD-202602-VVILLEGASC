package Taller1.src.controller;

import Taller1.src.view.ConsoleView;

public class MainController {

    private final ConsoleView view;

    public MainController(ConsoleView view){
        this.view = view;
    }

    public void run(){
        boolean salir = false;
        while(!salir){
            int option = view.showMainMenu();
            switch (option){
                case 1:
                    new ArrayController(view).run();
                    break;
                case 2:
                    new StackController(view).run();
                    break;
                case 3:
                    new QueueController(view).run();
                    break;
                case 4: 
                    salir = true;
                    break;
            }
        }
        view.showGoodbye();;
        view.close();
    }
}
