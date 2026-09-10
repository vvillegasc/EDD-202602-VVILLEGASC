package view;
import java.util.Scanner;

public class ConsoleView {

    private final Scanner scanner;

    public ConsoleView(){
        this.scanner=new Scanner(System.in);
    }

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


    public int maxSize(String structure){
        return readIntInRange("Ingrese el máximo del " + structure + ": ",1, Integer.MAX_VALUE);
    }

    public int askInt(String message){
        return readIntInRange(message, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int position(){
        return readIntInRange("Posición: ",0,Integer.MAX_VALUE);
    }


    public void showMessage(String message){
        System.out.println(message);
    }

    public void showError(String message){
        System.out.println("ERROR: " + message);
    }

    public void showResult(String label, int value){
        System.out.println(label + ": " + value);
    }

    public void showBoolean(String question, boolean value){
        System.out.println(question + ": " + (value ? "si" : "no"));
    }

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

    public void showGoodbye(){
        System.out.println();
        System.out.println("Aplicación finalizada. Adiós!");
    }

    public void pause(){
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }

    public void close(){
        scanner.close();
    }

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
