package controller;

import model.Queue;
import view.ConsoleView;

public class QueueController {

    private final ConsoleView view;

    public QueueController(ConsoleView view){
        this.view=view;
    }

    public void run(){
        int maxSize = view.maxSize("cola");
        Queue queue = new Queue(maxSize);

        boolean volver = false;
        while (!volver){
            int option = view.showQueueMenu();
            switch(option){
                case 1:
                    encolar(queue);
                    break;
                case 2:
                    desencolar(queue);
                    break;
                case 3:
                    verPrimero(queue);
                    break;
                case 4:
                    view.showContents("Cola (frente -> final)", queue.toArray());
                    break;
                case 5:
                    view.showResult("Cantidad de elementos", queue.size());
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

    private void encolar(Queue queue){
        int value = view.askInt("Valor a encolar:");
        try {
            queue.enqueue(value);
            view.showMessage("Elemento " + value + " encolado");
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }

    private void desencolar (Queue queue){
        try {
            view.showResult("Elemento desencolado", queue.dequeue());
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }

    private void verPrimero(Queue queue){
        try {
            view.showResult("Primer elemento", queue.peek());
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }
}
