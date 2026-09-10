package model;

/**
 * Arreglo de enteros de tamaño fijo (estructura vista en clase).
 *
 * <p>Es un <b>modelo</b> del patrón MVC: no imprime ni lee nada por consola.
 * Cuando una operación no se puede realizar lanza una excepción y es el
 * controlador quien decide qué mostrar a través de la vista.</p>
 */
public class Array {
	/** Almacenamiento interno; su longitud es la capacidad máxima. */
	private int[] array;
	/** Capacidad máxima del arreglo. */
	private int size;
	/** Cantidad de elementos realmente almacenados (0..size). */
	private int nItems;

	/**
	 * Crea un arreglo vacío con capacidad para {@code maxSize} elementos.
	 *
	 * @param maxSize capacidad máxima del arreglo
	 */
	public Array(int maxSize){
		size = maxSize;
		array = new int[size];
		nItems = 0;
	}

	/**
	 * Inserta un elemento al final del arreglo.
	 *
	 * @param item valor a insertar
	 * @throws IllegalStateException si el arreglo ya está lleno
	 */
	public void insert(int item){
        if(nItems == size){
            throw new IllegalStateException("Array is full");
        }
		int i = nItems;
		array[i] = item;
		nItems++;
		return;
	}

	/**
	 * Busca la primera aparición de un valor.
	 *
	 * @param item valor a buscar
	 * @return la posición (0..nItems-1) donde aparece, o {@code -1} si no está
	 */
	public int find(int item){
		for (int i=0; i<nItems; i++){
			if (array[i] == item) return i;
		}
		return -1;
	}

	/**
	 * Elimina el elemento de la posición indicada y desplaza los siguientes
	 * una casilla hacia la izquierda.
	 *
	 * @param position índice a eliminar (0..nItems-1)
	 * @throws IndexOutOfBoundsException si la posición está fuera de rango
	 */
    public void deleteByPosition(int position){
        if(position < 0 || position >= nItems){
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        for(int i = position; i<nItems-1; i++){
            array[i] = array[i+1];
        }
        nItems--;
    }

	/**
	 * Devuelve el valor máximo almacenado en el arreglo.
	 *
	 * @return el mayor de los elementos
	 * @throws IllegalStateException si el arreglo está vacío
	 */
    public int getMax(){
        if(nItems ==0){
            throw new IllegalStateException("Array is empty");
        }
        int max = array[0];
        for (int i = 1; i< nItems;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }

    /**
     * Devuelve una copia con solo los elementos reales, sin imprimir nada.
     * Reemplaza a {@code traverse()} para respetar MVC: la vista se encarga
     * de mostrar el contenido.
     *
     * @return copia de longitud {@code nItems} con los datos actuales
     */
    public int[] toArray(){
        int[] copy = new int[nItems];
        for(int i = 0; i < nItems; i++){
            copy[i] = array[i];
        }
        return copy;
    }


}
