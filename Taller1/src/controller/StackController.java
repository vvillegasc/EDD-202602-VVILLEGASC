package controller;

import model.Stack;
import view.ConsoleView;

/**
 * Controlador del submenú de Pila.
 *
 * <p>Une cada opción del menú que muestra la vista con el método
 * correspondiente del modelo {@link Stack}. Atrapa las excepciones del
 * modelo y le pide a la vista que muestre el mensaje de error. El
 * controlador no imprime ni lee directamente.</p>
 */
public class StackController {

    /** Vista para leer entradas y mostrar resultados. */
    private final ConsoleView view;

    /**
     * Crea el controlador de Pila.
     *
     * @param view vista de consola que se usará para toda la entrada/salida
     */
    public StackController(ConsoleView view){
        this.view = view;
    }

    /**
     * Pide el tamaño de la pila, la crea y repite el submenú hasta que el
     * usuario elige "Volver al menú principal". Tras cada operación hace
     * una pausa para que el resultado quede visible.
     */
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
                    break;
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

    /**
     * Opción 1: pide un valor y lo apila.
     *
     * @param stack pila sobre la que se opera
     */
    private void apilar(Stack stack){
        int value = view.askInt("Valor a apilar: ");
        try {
            stack.push(value);
            view.showMessage("Elemento " + value + "apilado");
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }

    /**
     * Opción 2: desapila el elemento de la cima y lo muestra.
     *
     * @param stack pila sobre la que se opera
     */
    private void desapilar(Stack stack){
        try {
            view.showResult("Elemento desapilado", stack.pop());
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }

    /**
     * Opción 3: muestra el elemento de la cima sin desapilarlo.
     *
     * @param stack pila sobre la que se opera
     */
    private void verCima(Stack stack){
        try {
            view.showResult("Cima", stack.peek());
        } catch (IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }
}
