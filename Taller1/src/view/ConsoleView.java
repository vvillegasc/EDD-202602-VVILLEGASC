package view;
import java.util.Scanner;

/**
 * Capa <b>Vista</b> del patrón MVC.
 *
 * <p>Es la única clase que interactúa con la consola: imprime los menús y
 * los mensajes con {@code System.out} y lee la entrada del usuario con un
 * {@code Scanner}. No conoce el modelo ni ejecuta lógica de negocio; solo
 * muestra lo que el controlador le pasa y devuelve lo que el usuario
 * escribe. Toda la validación de entrada (números, rangos, reintentos)
 * vive aquí.</p>
 */
public class ConsoleView {

    /** Lector de la entrada estándar, compartido por toda la vista. */
    private final Scanner scanner;

    /** Crea la vista y abre el lector sobre {@code System.in}. */
    public ConsoleView(){
        this.scanner=new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y pide una opción válida.
     *
     * @return opción elegida: 1 Arreglo, 2 Pila, 3 Cola, 4 Salir
     */
    public int showMainMenu(){
        System.out.println();
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("1. Trabajar con Arreglo");
        System.out.println("2. Trabajar con Pila");
        System.out.println("3. Trabajar con Cola");
        System.out.println("4. Salir");
        System.out.println();
        return readIntInRange("Seleccione una opción: ", 1, 4);
    }

    /**
     * Muestra el submenú del arreglo y pide una opción válida.
     *
     * @return opción elegida (1-6; 6 = volver al menú principal)
     */
    public int showArrayMenu(){System.out.println();
        System.out.println("MENÚ ARREGLO");
        System.out.println("1. Insertar elemento ");
        System.out.println("2. Eliminar elemento por posición");
        System.out.println("3. Buscar elemento");
        System.out.println("4. Mostrar todos los elementos");
        System.out.println("5. Obtener el valor máximo");
        System.out.println("6. Volver al menú principal");
        System.out.println();
        return readIntInRange("Seleccione una opción: ", 1, 6);
    }

    /**
     * Muestra el submenú de la pila y pide una opción válida.
     *
     * @return opción elegida (1-6; 6 = volver al menú principal)
     */
    public int showStackMenu(){System.out.println();
        System.out.println("MENÚ PILA");
        System.out.println("1. Apilar (push)");
        System.out.println("2. Desapilar (pop)");
        System.out.println("3. Ver primer elemento (peek)");
        System.out.println("4. Mostrar contenido de la pila");
        System.out.println("5. La pila está vacía?");
        System.out.println("6. Volver al menú principal");
        System.out.println();
        return readIntInRange("Seleccione una opción: ", 1, 6);
    }

    /**
     * Muestra el submenú de la cola circular y pide una opción válida.
     *
     * @return opción elegida (1-6; 6 = volver al menú principal)
     */
    public int showQueueMenu(){System.out.println();
        System.out.println("MENÚ COLA CIRCULAR");
        System.out.println("1. Encolar (enqueue)");
        System.out.println("2. Desencolar (dequeue)");
        System.out.println("3. Ver primer elemento (peek)");
        System.out.println("4. Mostrar contenido de la cola");
        System.out.println("5. Cantidad de elementos en la cola");
        System.out.println("6. Volver al menú principal");
        System.out.println();
        return readIntInRange("Seleccione una opción: ", 1, 6);
    }


    /**
     * Pide el tamaño máximo de una estructura antes de crearla.
     *
     * @param structure nombre a mostrar (p. ej. "arreglo", "pila", "cola")
     * @return capacidad máxima elegida (mayor o igual a 1)
     */
    public int maxSize(String structure){
        return readIntInRange("Ingrese el máximo del " + structure + ": ",1, Integer.MAX_VALUE);
    }

    /**
     * Pide un valor entero cualquiera (por ejemplo, el elemento a insertar).
     *
     * @param message texto a mostrar antes de leer
     * @return entero ingresado por el usuario
     */
    public int askInt(String message){
        return readIntInRange(message, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Pide una posición (índice). No puede ser negativa; el límite superior
     * lo valida el modelo, que lanzará la excepción correspondiente.
     *
     * @return posición ingresada (mayor o igual a 0)
     */
    public int position(){
        return readIntInRange("Posición: ",0,Integer.MAX_VALUE);
    }


    /**
     * Muestra un mensaje informativo.
     *
     * @param message texto a mostrar
     */
    public void showMessage(String message){
        System.out.println(message);
    }

    /**
     * Muestra un mensaje de error (normalmente el de una excepción que el
     * controlador atrapó del modelo).
     *
     * @param message descripción del error
     */
    public void showError(String message){
        System.out.println("ERROR: " + message);
    }

    /**
     * Muestra un resultado con etiqueta, p. ej. {@code Valor máximo: 42}.
     *
     * @param label descripción del valor
     * @param value valor a mostrar
     */
    public void showResult(String label, int value){
        System.out.println(label + ": " + value);
    }

    /**
     * Muestra una respuesta de sí/no, p. ej. {@code ¿Está vacía?: si}.
     *
     * @param question pregunta a mostrar
     * @param value    respuesta booleana
     */
    public void showBoolean(String question, boolean value){
        System.out.println(question + ": " + (value ? "si" : "no"));
    }

    /**
     * Muestra el contenido de una estructura recibido como arreglo de
     * enteros. Si está vacío lo indica explícitamente.
     *
     * @param tittle título a mostrar antes del contenido
     * @param data   datos ya extraídos por el modelo (via {@code toArray})
     */
    public void showContents(String tittle, int[] data){
        System.out.print(tittle +": ");
        if(data == null || data.length == 0){
            System.out.println("(vacío)");
            return;
        }
        String contenido = "[";
        for (int i=0; i<data.length;i++){
            contenido = contenido + data[i];
            if(i + 1 < data.length){
                contenido = contenido + ",";
            }
        }
        contenido = contenido+ "]";
        System.out.println(contenido);
    }

    /**
     * Muestra el contenido de una pila en vertical, con la cima arriba y la
     * base abajo, para que se vea como una pila y no como una lista.
     *
     * @param tittle título a mostrar antes del contenido
     * @param data   datos de la pila (posición 0 = cima), ya extraídos por el
     *               modelo (via {@code toArray})
     */
    public void showStack(String tittle, int[] data){
        System.out.println(tittle + ":");
        if(data == null || data.length == 0){
            System.out.println("  (vacía)");
            return;
        }
        int ancho = 0;
        for(int valor : data){
            ancho = Math.max(ancho, String.valueOf(valor).length());
        }
        String borde = "  +" + "-".repeat(ancho + 2) + "+";
        System.out.println(borde);
        for(int i = 0; i < data.length; i++){
            String celda = String.valueOf(data[i]);
            while(celda.length() < ancho){
                celda = " " + celda;
            }
            String marca = (i == 0) ? "  <- cima" : (i == data.length - 1) ? "  <- base" : "";
            System.out.println("  | " + celda + " |" + marca);
            System.out.println(borde);
        }
    }

    /** Muestra el mensaje de despedida al salir de la aplicación. */
    public void showGoodbye(){
        System.out.println();
        System.out.println("Aplicación finalizada. Adiós!");
    }

    /** Detiene la ejecución hasta que el usuario presione Enter. */
    public void pause(){
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }

    /** Cierra el lector de entrada. Se llama una sola vez, al terminar. */
    public void close(){
        scanner.close();
    }

    /**
     * Lee una línea y la convierte a entero, reintentando hasta que el
     * usuario ingrese un número válido dentro del rango indicado. Atrapa
     * {@link NumberFormatException} cuando la entrada no es numérica.
     *
     * @param message texto a mostrar en cada intento
     * @param min     valor mínimo aceptado (inclusive)
     * @param max     valor máximo aceptado (inclusive)
     * @return un entero válido dentro de [{@code min}, {@code max}]
     */
    private int readIntInRange(String message, int min, int max){
        while(true){
            System.out.print(message);
            String line = scanner.nextLine().trim();
            try{
                int value = Integer.parseInt(line);
                if(value < min || value >max){
                    if(min == Integer.MIN_VALUE){
                        System.out.println(" > El valor no puede ser mayor de " + max);
                    }else if (max == Integer.MAX_VALUE){
                        System.out.println("> El valor debe ser mayor o igual a " + min);
                    }else{
                        System.out.println("> Ingrese un número entre " + min + " y " + max);
                    }
                    continue;
                }
                return value;
            } catch (NumberFormatException e){
                System.out.println("> Ingrese un número válido");
            }
        }
    }
}
