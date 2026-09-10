package controller;

import view.ConsoleView;

/**
 * Controlador principal de la aplicación.
 *
 * <p>Maneja el ciclo del menú principal: según la opción elegida crea y
 * ejecuta el controlador de Arreglo, Pila o Cola, y repite hasta que el
 * usuario elige "Salir". No imprime ni lee directamente: para eso usa la
 * {@link ConsoleView}.</p>
 */
public class MainController {

    /** Vista compartida con los sub-controladores. */
    private final ConsoleView view;

    /**
     * Crea el controlador principal.
     *
     * @param view vista de consola que usarán este controlador y los
     *             sub-controladores que cree
     */
    public MainController(ConsoleView view){
        this.view = view;
    }

    /**
     * Muestra el menú principal en un bucle y delega cada opción en el
     * sub-controlador correspondiente. Al elegir "Salir" se despide y
     * cierra la entrada.
     */
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
