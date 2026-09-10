package controller;

import model.Array;
import view.ConsoleView;

/**
 * Controlador del submenú de Arreglo.
 *
 * <p>Une cada opción del menú que muestra la vista con el método
 * correspondiente del modelo {@link Array}. Cuando el modelo lanza una
 * excepción, la atrapa y le pide a la vista que muestre el mensaje de
 * error. El controlador no imprime ni lee directamente.</p>
 */
public class ArrayController {
    /** Vista para leer entradas y mostrar resultados. */
    private final ConsoleView view;
    /** Modelo que maneja este controlador; se crea en {@link #run()}. */
    private Array array;

    /**
     * Crea el controlador de Arreglo.
     *
     * @param view vista de consola que se usará para toda la entrada/salida
     */
    public ArrayController (ConsoleView view){
        this.view = view;
    }

    /**
     * Pide el tamaño del arreglo, lo crea y repite el submenú hasta que el
     * usuario elige "Volver al menú principal". Tras cada operación hace
     * una pausa para que el resultado quede visible.
     */
    public void run(){
        int maxSize = view.maxSize("arreglo");
        this.array = new Array(maxSize);

        boolean volver = false;
        while(!volver){
            switch(view.showArrayMenu()){
                case 1:
                    insertar();
                    break;
                case 2:
                    eliminar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    mostrar();
                    break;
                case 5:
                    obtenerMaximo();
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


    /** Opción 1: pide un valor y lo inserta al final del arreglo. */
    private void insertar(){
        int value = view.askInt("Valor a insertar:");
        try{
            array.insert(value);
            view.showMessage("Elemento " + value + " insertado");
        } catch (IllegalStateException e){
            view.showError(e.getMessage());
        }
    }

    /** Opción 2: pide una posición y elimina el elemento que hay en ella. */
    private void eliminar(){
        int position = view.position();
        try {
            array.deleteByPosition(position);
            view.showMessage("Elemento en la posición " + position + " eliminad");
        } catch (IndexOutOfBoundsException e){
            view.showError(e.getMessage());
        }
    }

    /** Opción 3: pide un valor y muestra en qué posición está (o si no está). */
    private void buscar(){
        int value = view.askInt("Valor a buscar:");
        int index = array.find(value);
        if(index == -1){
            view.showMessage ("El elemento " + value + " no está en el arreglo");
        }else{
            view.showResult("Encontrado en la posición", index);
        }
     }

    /** Opción 4: muestra todos los elementos del arreglo. */
     private void mostrar(){
        view.showContents("Arreglo", array.toArray());
     }

    /** Opción 5: muestra el valor máximo del arreglo. */
     private void obtenerMaximo(){
        try{
            view.showResult("Valor máximo", array.getMax());
        }catch (IllegalStateException e){
            view.showError(e.getMessage());
        }
     }
 }
