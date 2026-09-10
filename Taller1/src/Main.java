import controller.MainController;
import view.ConsoleView;

/**
 * Punto de entrada de la aplicación.
 *
 * <p>Taller 1 &mdash; Arreglos, Pilas y Colas bajo el patrón
 * Modelo&ndash;Vista&ndash;Controlador. Esta clase solo arma las piezas del
 * patrón (la vista de consola y el controlador principal) y les cede el
 * control; no contiene lógica de negocio ni de interfaz.</p>
 */
public class Main {

    /** Clase utilitaria: no se instancia. */
    private Main() {
    }

    /**
     * Crea la {@link ConsoleView} y el {@link MainController}, y arranca el
     * ciclo del menú principal.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        MainController controller = new MainController(view);
        controller.run();
    }
}
