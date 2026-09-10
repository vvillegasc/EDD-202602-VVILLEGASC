package controller;

import model.Queue;
import view.ConsoleView;

/**
 * Controlador del submenú de Cola circular.
 *
 * <p>Une cada opción del menú que muestra la vista con el método
 * correspondiente del modelo {@link Queue}. Atrapa las excepciones del
 * modelo y le pide a la vista que muestre el mensaje de error. El
 * controlador no imprime ni lee directamente.</p>
 */
public class QueueController {

    /** Vista para leer entradas y mostrar resultados. */
    private final ConsoleView view;

    /**
     * Crea el controlador de Cola circular.
     *
     * @param view vista de consola que se usará para toda la entrada/salida
     */
    public QueueController(ConsoleView view){
        this.view=view;
    }

    /**
     * Pide el tamaño de la cola, la crea y repite el submenú hasta que el
     * usuario elige "Volver al menú principal". Tras cada operación hace
     * una pausa para que el resultado quede visible.
     */
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

    /**
     * Opción 1: pide un valor y lo encola al final.
     *
     * @param queue cola sobre la que se opera
     */
    private void encolar(Queue queue){
        int value = view.askInt("Valor a encolar:");
        try {
            queue.enqueue(value);
            view.showMessage("Elemento " + value + " encolado");
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }

    /**
     * Opción 2: saca el primer elemento de la cola y lo muestra.
     *
     * @param queue cola sobre la que se opera
     */
    private void desencolar (Queue queue){
        try {
            view.showResult("Elemento desencolado", queue.dequeue());
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }

    /**
     * Opción 3: muestra el primer elemento de la cola sin sacarlo.
     *
     * @param queue cola sobre la que se opera
     */
    private void verPrimero(Queue queue){
        try {
            view.showResult("Primer elemento", queue.peek());
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }
}
