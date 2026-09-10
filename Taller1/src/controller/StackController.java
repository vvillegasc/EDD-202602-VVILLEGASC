package Taller1.src.controller;

import Taller1.src.model.Stack;
import Taller1.src.view.ConsoleView;

public class StackController {

    private final ConsoleView view;

    public StackController(ConsoleView view){
        this.view = view;
    }

    public void run(){
        int maxSize = view.maxSize("pila");
        Stack stack = new Stack(maxSize);

        boolean volver = false;
        while(!volver){
            int option = view.showStackMenu();
            switch(option){
                case 1:
                    apilar(stack);
                    break;
                case 2:
                    desapilar(stack);
                    break;
                case 3:
                    verCima(stack);
                case 4:
                    view.showContents("Pila (cima -> base",stack.toArray());
                    break;
                case 5:
                    view.showBoolean("¿La pila está vacía?", stack.isEmpty());
                    break;
                case 6:
                    volver = true;
                    break;
            }
            if(!volver){
                view.pause();
            }
        }
    }

    private void apilar(Stack stack){
        int value = view.askInt("Valor a apilar: ");
        try {
            stack.push(value);
            view.showMessage("Elemento " + value + "apilado");
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }

    private void desapilar(Stack stack){
        try {
            view.showResult("Elemento desapilado", stack.pop());
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }

    private void verCima(Stack stack){
        try {
            view.showResult("Cima", stack.peek());
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }
}
