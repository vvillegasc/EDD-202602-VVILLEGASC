package controller;

import model.Array;
import view.ConsoleView;

public class ArrayController {
    private final ConsoleView view;
    private Array array;

    public ArrayController (ConsoleView view){
        this.view = view;
    }

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


    private void insertar(){
        int value = view.askInt("Valor a insertar:");
        try{
            array.insert(value);
            view.showMessage("Elemento " + value + " insertado");
        } catch (IllegalStateException e){
            view.showError(e.getMessage());
        }
    }

    private void eliminar(){
        int position = view.position();
        try {
            array.deleteByPosition(position);
            view.showMessage("Elemento en la posición " + position + " eliminad");
        } catch (IndexOutOfBoundsException e){ 
            view.showError(e.getMessage());
        }
    }

    private void buscar(){
        int value = view.askInt("Valor a buscar:");
        int index = array.find(value);
        if(index == -1){
            view.showMessage ("El elemento " + value + " no está en el arreglo");
        }else{
            view.showResult("Encontrado en la posición", index);
        }
     }

     private void mostrar(){
        view.showContents("Arreglo", array.toArray());
     }

     private void obtenerMaximo(){
        try{
            view.showResult("Valor máximo", array.getMax());
        }catch (IllegalStateException e){
            view.showError(e.getMessage());
        }
     }
 }



